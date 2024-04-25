package DataStructure;

// 我们的第五版Union-Find
public interface UF {

    int getSize();

    boolean isConnected(int p, int q);

    void unionElements(int p, int q);
}
