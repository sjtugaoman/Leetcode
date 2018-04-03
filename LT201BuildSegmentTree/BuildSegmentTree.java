//Definition of Segment Tree Node
class SegmentTreeNode {
    public int start, end;
    public SegmentTreeNode left, right;
    public SegmentTreeNode(int start, int end) {
        this.start = start;
        this.end = end;
        this.left = this.right = null;
    }
}

public class BuildSegmentTree{
    public static SegmentTreeNode build(int start, int end) {
        if(start > end) return null;

        SegmentTreeNode root = new SegmentTreeNode(start, end);
        if(start != end) {
            int mid = start + (end - start) / 2;
            root.left = build(start, mid);
            root.right = build(mid + 1, end);
        }
        return root;
    }

    public static void main(String[] args) {
        System.out.println(build(0, 5));
    }
}