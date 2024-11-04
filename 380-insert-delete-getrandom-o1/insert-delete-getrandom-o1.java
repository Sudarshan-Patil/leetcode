class RandomizedSet {
    HashMap<Integer, Integer> hm;
    ArrayList<Integer> arr = new ArrayList<>();
    public RandomizedSet() {
        hm = new HashMap<>();
    }
    
    public boolean insert(int val) {
        if (!hm.containsKey(val)) {
            arr.add(val);
            hm.put(val, arr.size()-1);
            return true;
        }
        return false;
    }
    
    public boolean remove(int val) {
        if (hm.containsKey(val)) {
            int n = arr.size()-1;
            arr.set(hm.get(val), arr.get(n));
            hm.put(arr.get(n), hm.get(val));
            hm.remove(val);
            arr.remove(arr.size()-1);
            return true;
        }
        return false;
    }
    
    public int getRandom() {
        int index = (int)(Math.random()*arr.size());
        while (arr.get(index) == null) {
            index = (int)(Math.random()*arr.size());
        }

        return arr.get(index);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */