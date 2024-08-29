package 并查集.快Union慢Find;

public class UnionFind {
    // 父节点
    private int[] parent;
    // 组数
    private int size;
    // 初始化
    public UnionFind(int size){
        this.size = size;
        this.parent = new int[size];
        for(int i = 0;i<size;i++){
            parent[i] = i;
        }
    }
    // 查找
    public int find(int element){
        while(element!=parent[element]){
            element = parent[element];
        }
        return element;
    }
    // 是否同一组
    public boolean isConnected(int firstElement, int secondElement){
        return find(firstElement) == find(secondElement);
    }
    // 合并组
    public void unionElements(int firstElement, int secondElement){
        int firstParent = find(firstElement);
        int secondParent = find(secondElement);
        if(firstParent == secondParent) return;
        parent[firstParent] = secondParent;
    }
    // 打印
    public void printArr(){
        for(int i : parent){
            System.out.print(i + "\t");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int n = 10;
        UnionFind union = new UnionFind(n);
        System.out.println("初始：");
        union.printArr();

        System.out.println("连接 5 6");
        union.unionElements(5, 6);
        union.printArr();

        System.out.println("连接 1 2");
        union.unionElements(1, 2);
        union.printArr();

        System.out.println("1和2是否连接"+union.isConnected(1,2));
        System.out.println("1和6是否连接"+union.isConnected(1,6));
    }
}
