package Task08;

import java.util.*;

public class ListMod {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("my");
        list.add("dear");
        list.add("friend");
        list.add("not");
        list.add("my");
        list.add("cat");

        List<String> revertedList1 = revertListVersion1(list);
        List<String> revertedList2 = revertListVersion2(list);
        List<String> listWithShortStrings = deleteStringsLongerGivenLength(list, 4);
        List<String> uniqueListSet = deleteDuplicateElemsWithSet(list);
        List<String> uniqueListNoSet = deleteDuplicateElemsWithoutSet(list);

        System.out.println("Reverted list 1st version: " + revertedList1
                + "\nReverted list 2nd version: " + revertedList2
                + "\nList with elems.length <= 4: " + listWithShortStrings
                + "\nUnique list using set: " + uniqueListSet
                + "\nUnique list without using set: " + uniqueListNoSet);

    }

    private static List<String> revertListVersion1(List<String> list) {
        //версия 1 не является лучшим решением, но имеет право на существование

        String[] strings = new String[list.size()];
        list.toArray(strings);
        String[] strings1 = new String[list.size()];

        for (int i = 0, j = list.size() - 1; i < list.size(); i++, j--) {
            strings1[i] = strings[j];
        }
        return Arrays.asList(strings1);
    }

    private static List<String> revertListVersion2(List<String> list) {
        List<String> list1 = new ArrayList<>();
        for (int i = 0, j = list.size() - 1; i < list.size(); i++, j--) {
            list1.add(i, list.get(j));
        }
        return list1;
    }

    private static List<String> deleteStringsLongerGivenLength(List<String> list, int maxStringLength) {
        List<String> list1 = new ArrayList<>();
        for (String string : list) {
            if (string.length() <= maxStringLength) {
                list1.add(string);
            }
        }
        return list1;
    }

    private static List<String> deleteDuplicateElemsWithSet(List<String> list) {
        Set<String> set = new LinkedHashSet<>(list);
        return new ArrayList<>(set);
    }

    private static List<String> deleteDuplicateElemsWithoutSet(List<String> list) {
        List<String> list1 = new ArrayList<>();
        for (String string : list) {
            if (!list1.contains(string)) {
                list1.add(string);
            }
        }
        return list1;
    }
}
