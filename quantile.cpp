#pragma comment(linker,"/STACK:16777216")
#pragma  warning ( disable: 4786)
#include<iostream>
#include<cstring>
#include<cstdio>
#include<vector>
#include<map>
#include<set>
#include<string>st
#include<cmath>
#include<cstdlib>
#include<cctype>
#include<algorithm>
#include<queue>
#include<sstream>
#include<stack>
#include<list>
#include <bitset>
#include<iomanip>
#include <fstream>
#include<ctime>

using namespace std;

#define max(x,y) ((x)>(y)?(x):(y))
#define min(x,y) ((x)<(y)?(x):(y))

#define forl(i,a,b) for ( i = a; i < b; i++)
#define fore(i,a,b) for ( i = a; i <= b; i++)
#define forrev(i,a,b) for ( i = a; i >= b; i--)
#define pb push_back
typedef long long  LL;
#define in(a,b,c) ((a) <= (b) && (b) <= (c))
#define ms(a,b) memset((a),(b),sizeof(a))

#define all(v) (v).begin(),(v).end()
#define pb push_back
#define ull unsigned long long int

typedef vector<int> vi;
typedef pair<int,int> pii;
typedef vector<pii> vpii;

string to_string(long long x) { stringstream ss; ss << x; return ss.str(); }
long long to_int(const string &s) { stringstream ss; ss << s; long long x; ss >> x; return x; }

#define MAX 100005
int comp(pii a, pii b){
    if(a.first < b.first)
        return 1;
    else
        return 0;
}
int main(void)
{
    //freopen("1.txt", "r", stdin);
    //freopen("2.txt", "w", stdout);
    ull q,m;
    vector<pii> vpii;
    int i;
    ull k;
    int v,c;
    while(cin >> q){
        cin >> m;
        vpii.clear();
        forl(i,0,m){
            cin >> v >> c;
            vpii.pb(make_pair(v,c));
        }
        sort(all(vpii), comp);
        ull cnt[MAX];
        cnt[0] = vpii[0].second;
        forl(i,1,m){
            cnt[i] = cnt[i-1] + vpii[i].second;
        }
        ull n = cnt[m-1];
        forl(k,1,q+1){
            ull index = (n*k + q-1)/q;
            int l = 0;
            int r = m-1;
            ull ans=0;
            while(l<=r){
                int mid = (l+r)/2;
                if(cnt[mid] < index){
                    l = mid+1;
                }
                else if(cnt[mid] >= index && mid > 0 && cnt[mid-1] >= index){
                    r = mid-1;
                }
                else if(cnt[mid] >= index && mid > 0 && cnt[mid-1] < index){
                    ans = vpii[mid].first;
                    break;
                }
                else if(mid == 0){
                    ans = vpii[mid].first;
                    break;
                }
            }
            /*ull sum = 0;
            ull ans=0;
            forl(i,0,m){
                if(cnt[i] >= index){
                    ans = vpii[i].first;
                    break;
                }
            }*/
            cout << ans << endl;
        }

    }
    return 0;
}
