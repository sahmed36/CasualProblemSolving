#include <iostream>
#include <cstdio>
using namespace std;

void findIndex (int* arr, int n){


int first, last;
bool gotFirst = false;

for(int i=0; i<13; i++){
    if(arr[i]==n){
        if(!gotFirst){
            first = i;
            last = i;
            gotFirst = true;
        } else{
            last = i;
        }

    }

}
cout << endl << "Output is : " << endl;
cout << first << " " << last << endl;

}

int main(){

int array[] = {0,0,1,1,1,5,5,6,6,6,6,7,11};

for(int i=0; i<13; i++){
    cout << array[i];
}

findIndex(array, 6);

for(int i=1; i<=7/2; i++){

    cout<< i << endl;
}

return 0;
}
