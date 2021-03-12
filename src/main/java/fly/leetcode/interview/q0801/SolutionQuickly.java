package fly.leetcode.interview.q0801;


class matrix{
    long[][] m=new long[3][3];
    matrix(){};
}
class SolutionQuickly {
    static long mod=1000000007;

    public matrix mult_matrix(matrix a,matrix b){
        matrix c=new matrix();
        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
                for(int k=0;k<3;k++)
                    c.m[i][j]=(c.m[i][j]+a.m[i][k]*b.m[k][j]%mod)%mod;
        return c;
    }

    public matrix pow_matrix(matrix ans,matrix res,int y){
        while(y>0){
            if(y%2==1) ans=mult_matrix(ans,res);
            res=mult_matrix(res,res);
            y>>=1;
        }
        return ans;
    }

    public int waysToStep(int n) {
        if(n<=2) return n;
        matrix ans=new matrix(),res=new matrix();

        for(int i=0;i<3;i++)
            ans.m[i][i]=1;

        res.m[0][0]=1;
        res.m[0][1]=1;
        res.m[0][2]=1;
        res.m[1][0]=1;
        res.m[2][1]=1;
        ans=pow_matrix(ans,res,n-2);

        long cnt=(2*ans.m[0][0]%mod+ans.m[0][1]+ans.m[0][2])%mod;

        return (int)cnt;
    }
}
