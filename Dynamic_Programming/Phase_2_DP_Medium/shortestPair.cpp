#include<iostream>
using namespace std;

#define INF 100

int main() 
{
    int n;
    cout << "Enter number of vertices: ";
    cin >> n;

    vector<vector<int>> dist(n, vector<int>(n));

    cout << "Enter adjacency matrix (use 100 for INF):\n";

    // Input matrix
    for(int i = 0; i < n; i++) 
    {
        for(int j = 0; j < n; j++) 
        {
            cin >> dist[i][j];
        }
    }

    // Floyd-Warshall Algorithm
    for(int k = 0; k < n; k++) 
    {
        for(int i = 0; i < n; i++) 
        {
            for(int j = 0; j < n; j++) 
            {
                if(dist[i][k] < INF && dist[k][j] < INF) 
                {
                    dist[i][j] = min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
    }

    // Output result
    cout << "\nShortest distance matrix:\n";

    for(int i = 0; i < n; i++) {
        for(int j = 0; j < n; j++) {
            if(dist[i][j] == INF)
                cout << "∞ ";
            else
                cout << dist[i][j] << " ";
        }
        cout << endl;
    }

    // Check negative cycle
    for(int i = 0; i < n; i++) {
        if(dist[i][i] < 0) {
            cout << "\nNegative cycle detected!\n";
            return 0;
        }
    }

    cout << "\nNo negative cycle detected.\n";

    return 0;
}