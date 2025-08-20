import java.util.*;

public class LargestRectangleInHistogram {
    
    public static int[] prevSmaller(int[] heights){
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[heights.length];
        for(int i = 0; i < heights.length; i++){
            if(stack.isEmpty()){
                ans[i] = -1;
                stack.push(i);
            }
            else{
                while(!stack.isEmpty() && heights[i] <= heights[stack.peek()]){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    ans[i] = -1;
                }
                else{
                    ans[i] = stack.peek();
                }
                stack.push(i);
            }
        }
        return ans;
    }

    public static int[] nextSmaller(int[] heights){
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[heights.length];
        for(int i = heights.length - 1; i >= 0; i--){
            if(stack.isEmpty()){
                ans[i] = heights.length;
                stack.push(i);
            }
            else{
                while(!stack.isEmpty() && heights[i] <= heights[stack.peek()]){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    ans[i] = heights.length;
                }
                else{
                    ans[i] = stack.peek();
                }
                stack.push(i);
            }
        }
        return ans;
    }

    public static int largestRectangleArea(int[] heights) {
        int[] left = prevSmaller(heights);
        int[] right = nextSmaller(heights);
        int maxAns = 0;
        for(int i = 0; i < heights.length; i++){
            int height = heights[i];
            int width = right[i] - left[i] - 1;
            maxAns = Math.max(maxAns, height * width);
        }
	return maxAns;
    }

    	public static void main(String[] args){
		int ans = largestRectangleArea(new int[]{2,1,5,6,2,3});
		System.out.println(ans);
		ans = largestRectangleArea(new int[]{2,4});
		System.out.println(ans);
	}
}
