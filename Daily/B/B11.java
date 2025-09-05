package Daily.B;

import java.util.*;

class UserSolution {

    static List<Edge>[] edges; // edge정보 표시
    static int[] hotelToBrand; // 호텔과 브랜드 매핑
    static int[] brandParent; // 브랜드간 부모관계 표시
    static int[] brandCount; // 브랜드 숫자 표시
    static int hotelNum; //

    void init(int N, int mBrands[]) {
        hotelNum = N;
        edges = new ArrayList[N];
        brandCount = new int[50];

        for (int i = 0; i < N; i++) {
            edges[i] = new ArrayList<>();
            brandCount[mBrands[i]]++;
        }

        hotelToBrand = mBrands;
        brandParent = new int[50];
        // 초기 브랜드는 합병되지 않았기에 자기 자신으로 초기화
        for (int i = 0; i < 50; i++) brandParent[i] = i;
    }
    
    void connect(int mHotelA, int mHotelB, int mDistance) {
        // 도시 간선 추가
        edges[mHotelA].add(new Edge(mHotelB, mDistance));
        edges[mHotelB].add(new Edge(mHotelA, mDistance));
    }
    
    // b호텔을 a에 합병시킨다
    int merge(int mHotelA, int mHotelB) {
        // mHotelA의 현재 부모 브랜드
        int parentA = find(hotelToBrand[mHotelA]);
        
        // mHotelB의 현재 부모 브랜드
        int parentB = find(hotelToBrand[mHotelB]);
        
        // 두 브랜드가 같다면 바로 해당 브랜드의 호텔 숫자 반환
        if (parentA == parentB) return brandCount[parentA];
        
        // 브랜드 B의 부모를 A로 변경
        brandParent[parentB] = parentA;
        // 브랜드 A의 숫자에 브랜드 B 숫자 더하기
        brandCount[parentA] += brandCount[parentB];
        // 합병되었으니 b는 0이 된다.
        brandCount[parentB] = 0;
        
        return brandCount[parentA];
    }
    
    int find(int brandA) {
        // 브랜드 A의 부모 찾기
        if (brandParent[brandA] == brandA) return brandA;
        return brandParent[brandA] = find(brandParent[brandA]);
    }
    
    // 비용은 mStart에서 mBrandA로 걸리는 최솟값, mBrandB로 걸리는 최솟값 구하기
    int move(int mStart, int mBrandA, int mBrandB) {
        // 다익스트라 사용
        int[] dist = new int[hotelNum];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[mStart] = 0;
        
        PriorityQueue<Hotel> pq = new PriorityQueue<>();
        pq.add(new Hotel(mStart, 0));
        
        // 현재 브랜드 A의 최종(부모) 브랜드 구하기
        int brandA_root = find(mBrandA);
        // 현재 브랜드 B의 최종(부모) 브랜드 구하기
        int brandB_root = find(mBrandB);

        // 거리가 -1이라는건 아직 해당 브랜드의 호텔을 찾지 못했다는 것을 의미
        // 처음 발견하는 순간이 해당 브랜드의 호텔들중 가장 가까운 거리임
        int distA = -1;
        int distB = -1;
        
        while (!pq.isEmpty()) {
            Hotel cur = pq.poll();
            
            // 현재 거리가 dist에 기록된 거리보다 큰 경우 찾아볼 필요 없음 (최단 경로가 아니다)
            if (cur.dist > dist[cur.pos]) {
                continue;
            }
            
            // 현재 지점이 시작 지점이 아니라면
            if (cur.pos != mStart) {
                // 현재 지점의 브랜드 찾기
                int currentBrand_root = find(hotelToBrand[cur.pos]);
                
                // 현재 지점이 A브랜드와 같다면
                if (currentBrand_root == brandA_root) {
                    // A브랜드, B브랜드 모두 동일한 경우
                    if (brandA_root == brandB_root) { // 같은 브랜드
                        // distA가 갱신 되지 않았다면
                        if (distA == -1) {
                            distA = cur.dist;
                        } 
                        // distA가 갱신되었다면 distB를 갱신
                        else if (distB == -1) {
                            distB = cur.dist;
                        }
                    }
                    
                    // A브랜드, B브랜드가 서로 다른 경우
                    else { // 다른 브랜드
                        if (distA == -1) {
                            distA = cur.dist;
                        }
                    }
                }
                
                // 현재 브랜드가 B브랜드와는 같고, A브랜드와는 다른경우
                if (currentBrand_root == brandB_root && brandA_root != brandB_root) {
                    if (distB == -1) {
                        distB = cur.dist;
                    }
                }
            }
            
            // 두 거리를 모두 찾았으면 반환
            if (distA != -1 && distB != -1) {
                return distA + distB;
            }
            
            // 현재 pos와 연결된 edge들을 통해 갈 수 있는 다음 위치 넣어주기
            for (Edge next: edges[cur.pos]) {
                int newDist = cur.dist + next.dist;
                // 거리가 더 짧은 경우에만 pq에 넣어준다.
                if (dist[next.to] > newDist) {
                    dist[next.to] = newDist;
                    pq.add(new Hotel(next.to, newDist));
                }
            }
        }
        
        return distA + distB;
    }
}

class Hotel implements Comparable<Hotel> {
    int pos;
    int dist;
    
    Hotel(int pos, int dist) {
        this.pos = pos;
        this.dist = dist;
    }
    
    @Override
    public int compareTo(Hotel c) {
        return this.dist - c.dist;
    }
}

class Edge {
    int to;
    int dist;
    
    Edge(int to, int dist) {
        this.to = to;
        this.dist = dist;
    }
}