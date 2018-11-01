class RangeMinSolution{
    class SegmentTreeNode {
        int start, end, min;
        SegmentTreeNode left, right;
        public SegmentTreeNode(int s, int e) {
            this.start = s;
            this.end = e;
            this.min = 0;
            this.left = null;
            this.right = null;
        }
    }
    
    SegmentTreeNode root = null;
    public RangeMinSolution(int[] nums) {
        root = buildTree(nums, 0, nums.length - 1);
    }
    
    public int getRangeMin(int i, int j) {
        return getRangeMin(root, i, j);
    }
    
    private int getRangeMin(SegmentTreeNode root, int i, int j) {
        if(root.start == root.end) return root.min;
        int m = root.start + (root.end - root.start) / 2;
        if(j <= m) {
            return getRangeMin(root.left, i, j);
        } else if(i > m) {
            return getRangeMin(root.right, i, j);
        } else {
            return Math.min(getRangeMin(root.left, i, m), getRangeMin(root.right, m + 1, j));
        }
    }
    
    private SegmentTreeNode buildTree(int[] nums, int s, int e) {
        if(s > e) return null;
        SegmentTreeNode root = new SegmentTreeNode(s, e);
        if(s == e) {
            root.min = nums[s];
        } else {
            int mid = s + (e - s) / 2;
            root.left = buildTree(nums, s, mid);
            root.right = buildTree(nums, mid + 1, e);
            root.min = Math.min(root.left.min, root.right.min);
        }
        return root;
    }
}
public class RangeMinQuery {
    public static void main(String[] args) {
        int[] test = {10, 20, 30, 40, 11, 22, 33, 44, 15, 5};
        RangeMinSolution solution = new RangeMinSolution(test);
        
        System.out.println(solution.getRangeMin(1, 2));
    }
}