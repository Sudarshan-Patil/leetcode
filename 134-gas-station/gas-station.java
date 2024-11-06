class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
       int n = gas.length;
    
    int fulTrip = 0;
    int fuel = 0;
    int start = 0;
    int ans = 0;
    while (start < n) {
        fulTrip += gas[start] - cost[start];
        fuel += gas[start]-cost[start];
        if (fuel < 0) {
            fuel = 0;
            ans = start+1;
        }
        start++;
    }
    
    return fulTrip < 0 ? -1 : ans;
    }
}