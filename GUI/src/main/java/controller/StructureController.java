package controller;

import database.DBConnection;
import model.Structure;
import view.Homepage;
import view.Login;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class StructureController
{
    DBConnection db=new DBConnection();
    DependencyController dependencyController=new DependencyController();
    public int addStructure(int parent, int child){
        String query = "insert into structure (userId,jobId,parent,child) values ('"+
                Login.USER_ID+"', '"+ Homepage.JOB_ID+"','"+ parent+"', '"+ child+"');";
        return db.manipulate(query);
    }
public String[][] pairArray(){
    String query = "select * from structure where jobId = '" + Homepage.JOB_ID + "' and userId = '" + Login.USER_ID + "';";
    ResultSet rs = db.retrieve(query);
    Structure structure;
    ArrayList<String> parents=new ArrayList<>();
    ArrayList<String> children=new ArrayList<>();
    try {
        while (rs.next()) {
            structure=new Structure();
            int val=rs.getInt("parent");
            String p=dependencyController.returnId(val);
            parents.add(p);
            int val1=rs.getInt("child");
            String c=dependencyController.returnId(val1);
            parents.add(c);
            int t=parents.size();
            String[][] pairArray= new String[t][t];
            for (int i=0;i<t;i++){
                pairArray[i][0]=parents.get(i);
                pairArray[i][1]=children.get(i);

            }
            System.out.println(Arrays.deepToString(pairArray));
            return pairArray;
        }
        System.out.println(parents);
        System.out.println(children);
    }
    catch (SQLException e) {
        e.printStackTrace();
    }
    String[][] demo= new String[1][1];
  return demo;
}
public ArrayList<String> findSchedule(String[] dependencies,String[][] pairs){
    int depNo=dependencies.length;
    int pairNo=pairs.length;
    int[] index= new int[depNo];
    int[] indegree= new int[depNo];
    ArrayList<String> values = new ArrayList<String>();
    for(int k=0;k<depNo;k++){
        index[k]=k;
    }
    for(int i=0;i<depNo;i++){
        for(int j=0;j<pairNo;j++){
            if(pairs[j][1].equals(dependencies[i])){
                indegree[i]++;
            }
        }
    }
    Queue<Integer> queue = new LinkedList<>();
    for(int i=0;i<depNo;i++){
        if (indegree[i]==0){
            queue.add(index[i]);
        }
    }
    boolean visited[] = new boolean[depNo];
    while (!queue.isEmpty()){
        int val=queue.remove();
        visited[val]=true;
        values.add(dependencies[val]);
        System.out.println(dependencies[val]);
        for (int j = 0; j < pairNo; j++) {
            if (pairs[j][0].equals(dependencies[val])) {
                int child= Arrays.asList(dependencies).indexOf(pairs[j][1]);
                indegree[child]--;
                if (indegree[child] == 0 && !visited[child]) {
                    queue.add(child);
                }
            }
        }
    }
    return values;
}

}
