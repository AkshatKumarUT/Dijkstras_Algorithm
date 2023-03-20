/*  Dijkstras Algorithm that finds the shortest path to each node

*/

//package to be used when opened in Netbeans
//package dijkstrasalgorithm;

import java.util.ArrayList;

import java.util.PriorityQueue;

public class DijkstrasAlgorithm
{
  public static void printDistances(int[][] distances, char[] vertexNames)
  {
    for (int i = 0; i < distances.length; i++)
    {
      System.out.print("Distance from " + vertexNames[i]); 
      System.out.print(" is " + distances[i][0] + " last vertex is ");
      System.out.println(vertexNames[distances[i][1]]);
    }
  }

  public static void initializeDistances(int[][] distances)
  {
    //make starting vertex (A) have a distance of 0 from itself
    distances[0][0] = 0;
    distances[0][1] = 0;
    //making all other vertexes have a distance of infinity from start with no prev. vertex
    for (int i = 1; i < distances.length; i++)
    {
      distances[i][0] = (int) Double.POSITIVE_INFINITY;
      distances[i][1] = 0;
    }
  }
  
  public static void main(String[] args)
  {
    final int NUMBER_OF_NODES = 8;
    char[] vertexNames =
    {
      'A', 'B', 'C', 'D', 'F', 'G', 'H', 'J'
    };
    int[] A =
    {
      //a, b, c, d, f, g, h, j 
      -1, 4, 2, -1, -1, 7, -1 - 1
    };
    int[] B =
    {
      //a, b, c, d, f, g, h, j 
      4, -1, -1, 2, -1, -1, -1 - 1
    };
    int[] C =
    {
      //a, b, c, d, f, g, h, j 
      2, -1, -1, -1, 8, 3, -1, -1
    };
    int[] D =
    {
      //a, b, c, d, f, g, h, j 
      -1, 2, -1, -1, -1, 5, 6, -1
    };
    int[] F =
    {
      //a, b, c, d, f, g, h, j 
      -1, -1, 8, -1, -1, -1, -1, 3
    };
    int[] G =
    {
      //a, b, c, d, f, g, h, j 
      7, -1, 3, 5, -1, -1, -1, 4
    };
    int[] H =
    {
      //a, b, c, d, f, g, h, j 
      -1, -1, -1, 6, -1, -1, -1, 2
    };
    int[] J =
    {
      //a, b, c, d, f, g, h, j 
      -1, -1, -1, -1, 3, -1, 2, -1
    };

    int[][] graph =
    {
      A, B, C, D, F, G, H, J
    };
    int[][] unvisited = graph;
    
    ArrayList<int[]> unvisitedList = new ArrayList();
    for (int i = 0; i < unvisited.length; i++)
    {
      unvisitedList.add(unvisited[i]);
    }
    ArrayList<Integer> visitedList = new ArrayList();
    
    PriorityQueue myQueue = new PriorityQueue();

    // array of tuples with distance from start and last node
    //  eg. index 1 is a = [2, b]
    int[][] distances = new int[NUMBER_OF_NODES][2];

    //fill 2d array with zero values
    //fillWithZeros(distances);
    System.out.println(distances[0][1]);

    initializeDistances(distances);
    //printDistances(distances, vertexNames);
    System.out.println("");

    while (unvisitedList.size() != 0)
    {
      //System.out.println("iteration");
      //get the node with the shortest length
      int shortestDistance = (int) Double.POSITIVE_INFINITY;
      int smallestIndex = 0;
      int distanceOfCurrentVertex;
      int distanceToNeighbor;
      int distance;
      int[] currentVertex;
      int indexOfCurrentVertex;

      //find the vertex that is the shortest distance from the current Vertex
      for (int i = 0; i < distances.length; i++)
      {
        if (distances[i][0] < shortestDistance && !visitedList.contains(i))
        {
          shortestDistance = distances[i][0];
          smallestIndex = i;
        }
      }

      indexOfCurrentVertex = smallestIndex;
      currentVertex = graph[indexOfCurrentVertex];
      distanceOfCurrentVertex = distances[indexOfCurrentVertex][0];
      unvisitedList.remove(currentVertex);
      visitedList.add(indexOfCurrentVertex);

      //for every neighbor of current vertex that is still in the unvisited list
      for(int i=0; i<currentVertex.length; i++)
      {
        //distance isn't -1 (null) and neighbour is unvisited (not in visited)
        if(currentVertex[i] > 0 && !visitedList.contains(i))
        {
          distanceToNeighbor = currentVertex[i];
          //distance = distance of current vertex + distance from current vertex to neighbor
          distance = distanceOfCurrentVertex + distanceToNeighbor;
                    
          if(distance < distances[i][0])
          {
            distances[i][0] = distance;
            distances[i][1] = indexOfCurrentVertex;
          }
        }
      }
    }
    printDistances(distances, vertexNames);
  }
}
