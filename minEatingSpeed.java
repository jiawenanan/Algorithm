class Leetcode {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = 1000000000;
        while(l < r){
            int speed = l + (r - l) / 2;
            int counter = 0;
            for(int p : piles){
                counter += p % speed == 0 ? p / speed : p / speed + 1;
            }
            if(counter <= h) r = speed;
            if(counter > h) l = speed + 1;
        }
        return r;
    }
}