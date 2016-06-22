#include <map>
#include <set>
#include <list>
#include <cmath>
#include <ctime>
#include <climits>
#include <deque>
#include <queue>
#include <stack>
#include <bitset>
#include <cstdio>
#include <limits>
#include <vector>
#include <cstdlib>
#include <fstream>
#include <numeric>
#include <sstream>
#include <iostream>
#include <algorithm>
using namespace std;

/*
 * Complete the function below.
 */
vector < int > wiggleArrangeArray(vector < int > intArr) {
    vector < int > zigzagArr;

    sort(intArr.begin(), intArr.end());

    for(int i=1; i <= intArr.size()/2; i++) {

        zigzagArr.push_back(intArr[intArr.size()-i]);
        zigzagArr.push_back(intArr[i-1]);

    }

    if(intArr.size()%2 != 0){
        zigzagArr.push_back(intArr[(intArr.size()-1)/2]);
    }

    return zigzagArr;

}


int main() {
    ofstream fout(getenv("OUTPUT_PATH"));
    vector < int > res;

    int _intArr_size;
    cin >> _intArr_size;

    vector<int> _intArr;
    int _intArr_item;
    for(int _intArr_i=0; _intArr_i<_intArr_size; _intArr_i++) {
        cin >> _intArr_item;

        _intArr.push_back(_intArr_item);
    }

    res = wiggleArrangeArray(_intArr);
    for(int res_i=0; res_i < res.size(); res_i++) {
    	fout << res[res_i] << endl;;
    }

    fout.close();
    return 0;
}

