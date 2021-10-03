package bfs;

import java.util.*;

public class EvaluateDivision {

    class Edge{
        String dest;
        double weight;
        Edge(String dest,double weight){
            this.dest=dest;
            this.weight=weight;
        }
    }

    Map<String, List<Edge>> graph;

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        graph=new HashMap<>();
        Set<String> nodes=new HashSet<>();

        for(int i=0;i<equations.size();i++){
            String source=equations.get(i).get(0);
            String dest=equations.get(i).get(1);
            double weight=values[i];
            graph.putIfAbsent(source,new ArrayList<>());
            graph.get(source).add(new Edge(dest,weight));
            graph.putIfAbsent(dest,new ArrayList<>());
            graph.get(dest).add(new Edge(source,1/weight));
            //
            nodes.add(source);
            nodes.add(dest);
        }


        double[] result=new double[queries.size()];
        for(int i=0;i<queries.size();i++){
            String from=queries.get(i).get(0);
            String to=queries.get(i).get(1);
            if(from.equalsIgnoreCase(to) && nodes.contains(from)){
                result[i]=1.0;
            }else{
                result[i]=findresult(from,to,new ArrayList<>(),1.0);
            }
        }
        return result;
    }

    public double findresult(String from,String to,List<String> visited,double weightsofar){
        visited.add(from);
        if(graph.containsKey(from)){
            List<Edge> dest=graph.get(from);
            for(Edge edge : dest){
                if(!visited.contains(edge.dest)){
                    if(edge.dest.equalsIgnoreCase(to)){
                        return weightsofar*edge.weight;
                    }else{
                        double res=findresult(edge.dest,to,visited,weightsofar*edge.weight);
                        if(res!=-1){
                            return res;
                        }
                    }
                }
            }
        }
        return -1;
    }
}
