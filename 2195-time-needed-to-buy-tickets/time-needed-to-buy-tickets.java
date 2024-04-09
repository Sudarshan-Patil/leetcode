class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int count = 0;
        while(tickets[k] > 0){		    // track the kth index element till element is not become 0, when it will become 0 it will return count.
            for(int i = 0; i < tickets.length; i++){	// we iterate through array.
                if(tickets[i] == 0){			// if current element is 0 that means we donesn't need that element hence we skip it.
                    continue;
                }else{					// else if it is not 0, then we decrement value bu 1 and increment count.
                    tickets[i] = tickets[i] - 1;
                    count++;
                }
                if(tickets[k] == 0){		// if kth element is 0 that means we met our condition of exit hence we break.
                    break;
                }
            }
        }        
        return count;
    }
}