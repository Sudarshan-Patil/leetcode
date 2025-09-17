class FoodRatings 
{
    // coppied
    public class Pair
    {
        String f;
        int rating;
        public Pair(String food, int ratings)
        {
            f = food;
            rating = ratings;
        }
    }
    HashMap<String, Integer> foodMap = new HashMap<>();
    HashMap<String, String> cuisinemap = new HashMap<>();
    HashMap<String, PriorityQueue<Pair>> pqMap = new HashMap<>();
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings)
    {
        for(int i = 0; i < foods.length; i++)
        {
            pqMap.putIfAbsent(cuisines[i], new PriorityQueue<Pair>((a, b) -> b.rating == a.rating ? a.f.compareTo(b.f) : b.rating - a.rating));
            pqMap.get(cuisines[i]).offer(new Pair(foods[i], ratings[i]));
            foodMap.put(foods[i], ratings[i]);
            cuisinemap.put(foods[i], cuisines[i]);
        }
    }
    
    public void changeRating(String food, int newRating) 
    {
        String c = cuisinemap.get(food);
        pqMap.get(c).offer(new Pair(food, newRating));
        foodMap.put(food, newRating);
    }
    
    public String highestRated(String cuisine) 
    {
        PriorityQueue<Pair> pq = pqMap.get(cuisine);
        while(pq.peek().rating != foodMap.get(pq.peek().f))
        {
            pq.poll();
        }    
        return pq.peek().f;
    }
}