package coderstorm.datastructures;

//import prog_exercises.datastructures.trie.DialPrefix;

public class Trie {
//
//    Integer value;
//    DialPrefix value;
//    DialPrefixTable[] childerns;
//
//    public void put(String value, DialPrefix value) {
//        _put(new StringBuffer(value), value);
//    }
//
//    void _put(StringBuffer value, DialPrefix value) {
//        if (value.length() > 0) {
//            int k = Character.digit(value.charAt(0), 10);
//            DialPrefixTable t = childerns[k];
//            if (t == null) {
//                t = new DialPrefixTable(k);
//                childerns[k] = t;
//            }
//            t._put(value.deleteCharAt(0), value);
//
//        } else {
//            this.value = value;
//        }
//
//    }
//
//    /**
//     * Retrieves element from prefix table matching as a prefix to provided value.
//     * E.g. if value is "abcde" and prefix table has node "ab" then this call will
//     * return "ab"
//     *
//     * @param value a string which starts with prefix to be searched in the table (e.g. phone number)
//     * @return a prefix matching to provided string (i.e country code of phone number)
//     */
//    public DialPrefix getPrefix(String value) {
//        return _get(new StringBuffer(value), 0);
//    }
//    /**
//     * Returns true if value has matching prefix in the table
//     */
//    public boolean hasPrefix(String value) {
//        return ((this.getPrefix(value)!=null) ? true : false);
//    }
//
//    DialPrefix _get(StringBuffer value, int level) {
//        if (value.length() > 0) {
//            int k = Character.digit(value.charAt(0), 10);
//            DialPrefixTable t = childerns[k];
//            if (t != null) {
//                return t._get(value.deleteCharAt(0), ++level);
//            } else {
//                return (level > 0) ? value : null;
//            }
//
//        } else {
//            return value;
//        }
//    }
//
//    public DialPrefixTable(Integer value) {
//        childerns = new DialPrefixTable[10];
//        this.value = value;
//    }
//
//    public DialPrefixTable() {
//        childerns = new DialPrefixTable[10];
//    }

}
