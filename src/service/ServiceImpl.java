package service;

import reader.ReadIn;

import java.util.ArrayList;
import java.util.List;

public class ServiceImpl implements MyService {
    private final ReadIn readIn;

    public ServiceImpl(ReadIn readIn) {
        this.readIn = readIn;
    }

    @Override
    public List<String> arrays() {

        return comparison(readIn.getReader());
    }

    private List<String> comparison(List<List<String>> list) {
        List<String> result = new ArrayList<>();
        List<String> oneList = list.get(0);
        List<String> twoList = list.get(1);


        for (String stFromOneList : oneList) {

            String[] arrays = stFromOneList.split(" ");
            String st;
            if(arrays.length==1) {
                st = getString(twoList, stFromOneList.toLowerCase());

            } else {
                st = getStringFromArrays(twoList, arrays);
            }
            result.add(stFromOneList + ":" + st);

        }
        return result;
    }

    private String getStringFromArrays(List<String> twoList, String[] arrays) {
        String result = "?";
        for (String st : arrays){
           result = getString(twoList,st.toLowerCase());
           if(!result.equals("?"))
               break;
        }
        return result;
    }

    private String getString(List<String> twoList, String stFromOneList) {
        String result = "?";
        if(stFromOneList.length()>1) {
            for (String stFromTwoList : twoList) {
                if (stFromOneList.contains(stFromTwoList.toLowerCase()) || stFromTwoList.contains(stFromOneList)) {
                    result = stFromTwoList;
                }
            }
        }
        return result;
    }
}

