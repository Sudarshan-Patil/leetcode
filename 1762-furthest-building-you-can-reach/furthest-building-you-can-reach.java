class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int res = 0;
        PriorityQueue<Integer> differences = new PriorityQueue<>();
        for(int i = 0 ; i < heights.length-1 ; i++) {
            if(heights[i+1]>heights[i]){
                differences.add(heights[i+1]-heights[i]);
                if(differences.size()>ladders) {
                    bricks -= differences.poll();
                    if(bricks<0)
                        return res;
                }
            } 
            res++;
        }
        return res;
    }
}