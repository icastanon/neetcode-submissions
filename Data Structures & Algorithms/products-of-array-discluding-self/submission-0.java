class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefixProducts = new int[nums.length];
        prefixProducts[0] = 1;
        for(int i = 1; i < nums.length; i++){
            prefixProducts[i] = prefixProducts[i-1]*nums[i-1];
        }

        int[] sufixProducts = new int[nums.length];
        sufixProducts[nums.length-1] = 1;
        for(int i = nums.length-2; i >= 0; i--){
            sufixProducts[i] = sufixProducts[i+1]*nums[i+1];
        }

        int[] products = new int[nums.length];
        for(int i = 0; i < products.length; i++){
            products[i] = prefixProducts[i]*sufixProducts[i];
        }

        return products;
        
    }
}  
