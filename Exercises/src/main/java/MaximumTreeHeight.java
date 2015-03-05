/**
 * Get maximum tree height
 */
public class MaximumTreeHeight {
    String name;

    MaximumTreeHeight[] children;

    public MaximumTreeHeight(String name, MaximumTreeHeight[] children) {
        this.name = name;
        this.children = children;
    }

    int getMaxHeight() {
        int max = 0;

        if( nodeHasChildren() ) {
            for(MaximumTreeHeight c: children) {
                int h = c.getMaxHeight();
                if( h > max )
                    max = h;
            }
            return (max+1);
        }
        else {
            return 1;
        }

    }

    private boolean nodeHasChildren() {
        return (children!=null && children.length > 0);
    }

    public static void main(String[] args) {
        MaximumTreeHeight dev0 = new MaximumTreeHeight("dev0", null);
        MaximumTreeHeight dev1 = new MaximumTreeHeight("dev1", new MaximumTreeHeight[] {dev0});
        MaximumTreeHeight dev2 = new MaximumTreeHeight("dev2", null);
        MaximumTreeHeight pm1 = new MaximumTreeHeight("pm1", new MaximumTreeHeight[] {dev1, dev2});
        MaximumTreeHeight pm2 = new MaximumTreeHeight("pm2", null);
        MaximumTreeHeight pmo = new MaximumTreeHeight("ceo", new MaximumTreeHeight[] {pm1, pm2});
        MaximumTreeHeight coo = new MaximumTreeHeight("ceo", new MaximumTreeHeight[] {pm2});
        MaximumTreeHeight cto = new MaximumTreeHeight("ceo", new MaximumTreeHeight[] {pm1});
        MaximumTreeHeight ceo = new MaximumTreeHeight("ceo", new MaximumTreeHeight[] {cto, coo});

        System.out.println("ceo height=" + ceo.getMaxHeight());
        System.out.println("dev height=" + dev2.getMaxHeight());
        System.out.println("pm1 height=" + pm1.getMaxHeight());
    }
}
