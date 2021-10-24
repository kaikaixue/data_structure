package SqList;

public class SqTools {
    public static SqListClass<Integer> Reverse(SqListClass<Integer> L) {
        int i = 0;
        int j = L.size() - 1;
        while (i < j) {
            L.swap(i,j);
            i++;
            j--;
        }
        return L;
    }

    public static SqListClass<Integer> Merge2(SqListClass<Integer> A,SqListClass<Integer> B) throws Exception {
        SqListClass<Integer> C = new SqListClass<>();
        int i = 0;
        int j = 0;
        while(i < A.size() && j < B.size()) {
            if (A.GetElem(i) < B.GetElem(j)) {
                C.add(A.GetElem(i));
                i++;
            } else {
                C.add(B.GetElem(j));
                j++;
            }
        }
        while (i < A.size()) {
            C.add(A.GetElem(i));
            i++;
        }
        while (j < B.size()) {
            C.add(B.GetElem(j));
            j++;
        }
        return C;
    }

    public static SqListClass<Integer> Merge1(SqListClass<Integer> A,SqListClass<Integer> B) throws Exception {
        A.setSize(A.size() + B.size());
        for(int i = 0;i < B.size();i++) {
            for(int j = 0;j < A.size();j++) {
                if(B.GetElem(i) < A.GetElem(j)) {
                    A.insert(j,B.GetElem(i));
                    break;
                }
            }
        }
        return A;
    }
}
