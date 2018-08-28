

/**
 * @author: xiaolong
 * @Date: 下午11:47 2018/8/24
 * @Description:查找最长公共父节点
 * 只是一次查询的话可以这样写，如果多次查询的话建议使用：1.RMQ在线实现LCA，2：或者tarjan离线算法实现。
 */
public class CommonParent {
    public static TreeNode lowestCommonAncestor(TreeNode rt,TreeNode L,TreeNode R) {
        if(rt == null) {
            return null;
        }
        if(rt == L || rt == R) {
            return rt;
        }
        System.out.println(rt + " " + rt.left + " " + rt.right);
        TreeNode l = lowestCommonAncestor(rt.left,L,R);
        TreeNode r = lowestCommonAncestor(rt.right,L,R);
        return l != null && r != null ? rt : l != null ? l : r;
    }

    public static void main(String[] args) {
        //Test

        TreeNode[] trees = new TreeNode[10];
        for (int i = 1;i <= 9;i ++) {
            trees[i] = new TreeNode(i,null,null);
        }
        for(int i = 1;i <= 9;i ++) {
            if(i * 2 <= 9) {
                trees[i].left = trees[i * 2];
            }
            if(i * 2 + 1 <= 9) {
                trees[i].right = trees[i * 2  + 1];
            }
            System.out.println(trees[i] + " " + trees[i].left + " " + trees[i].right);
        }

        System.out.println(lowestCommonAncestor(trees[1],trees[5],trees[4]));

    }

}
class TreeNode {
    public int x;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(TreeNode left, TreeNode right) {
        this.left = left;
        this.right = right;
    }

    public TreeNode(int x, TreeNode left, TreeNode right) {
        this.x = x;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "" + x;
    }
}