package 并查集.快U快F_高度;

public class UnionFind {
    private int[] parent;
    private int[] height;
    private int size;
    // 初始化
    public UnionFind(int size){
        this.size = size;
        this.parent = new int[size];
        this.height = new int[size];
        for(int i = 0; i < size;i++){
            parent[i] = i;
            height[i] = 1;
        }
    }
    // 查找
    public int find(int element){
        while (element != parent[element]){
            element = parent[element];
        }
        return element;
    }
    // 是否一组
    public boolean isConnected(int firstElement, int secondElement){
        return find(firstElement) == find(secondElement);
    }
    // 合并
    public void unionElement(int firstElement, int secondElement){
        int firstParent = find(firstElement);
        int secondParent = find(secondElement);
        int firstHeight = height[firstElement];
        int secondHeight = height[secondElement];
        if(firstHeight > secondHeight){
            parent[secondParent] = firstParent;
        }else if(firstHeight < secondHeight){
            parent[firstParent] = secondParent;
        }else {
            parent[firstParent] = secondParent;
            height[secondParent] += 1;
        }
    }
    // 打印
    public void printArr(){
        for(int i : parent){
            System.out.print(i+"\t");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int n = 10;
        UnionFind union = new UnionFind(n);
        System.out.println("初始：");
        union.printArr();

        System.out.println("连接 5 6");
        union.unionElement(5, 6);
        union.printArr();

        System.out.println("连接 1 2");
        union.unionElement(1, 2);
        union.printArr();

        System.out.println("1和2是否连接"+union.isConnected(1,2));
        System.out.println("1和6是否连接"+union.isConnected(1,6));
    }
}
