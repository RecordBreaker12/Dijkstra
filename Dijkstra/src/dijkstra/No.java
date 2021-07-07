package dijkstra;

import java.util.Comparator;

class No implements Comparator<No>{
    public int no;
    public int custo;
 
    public No(){}
 
    public No(int no, int custo){
        this.no = no;
        this.custo = custo;
    }
 
    @Override
    public int compare(No no1, No no2){
        if (no1.custo< no2.custo){
            return -1;
        }
        if (no1.custo > no2.custo){
            return 1;
        }
        return 0;
    }
}
