package 并查集.基础;

public class UnionFind {
    // 所有的元素
    private int[] id;
    // 组数
    private int size;
    // 初始化并查集
    public UnionFind(int size){
        this.size = size;
        this.id = new int[size];
        for(int i = 0; i < size; i++){
            this.id[i] = i;
        }
    }
    // 查找元素所在的组数
    public int find(int element){
        return id[element];
    }
    // 是否在同一组
    public boolean isConnected(int firstElement, int secondElement){
        return id[firstElement]==id[secondElement];
    }
    // 合并并查集
    public void unionElements(int firstElement, int secondElement){
        int firstGroup = find(firstElement);
        int secondGroup = find(secondElement);
        if(firstGroup!=secondGroup){
            for(int i = 0;i<size;i++){
                if(id[i]==firstGroup){
                    id[i]=secondGroup;
                }
            }
        }
    }
    // 打印
    public void printArr(){
        for(int i : id){
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
