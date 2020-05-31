package step1;

import junit.framework.Assert;

//public class ComparisonCompactor {
//    private int contextLength;
//    private String expected;
//    private String actual;
//    private String compactExpected;
//    private String compactActual;
//    private int prefixLength;
//    private int suffixLength;
//
//    public ComparisonCompactor(int ctxt, String s1, String s2) {
//        this.ctxt = ctxt;
//        this.s1 = s1;
//        this.s2 = s2;
//    }
//
//    public String formatCompactedComparison(String message) {
//        if (canBeCompacted()) {
//            compactExpectedAndActual();
//            return Assert.format(message, compactExpected, compactActual);
//        } else {
//            return Assert.format(message, expected, actual);
//        }
//    }
//
//    private boolean canBeCompacted() {
//        return expected != null && actual != null && !areStringsEqual();
//    }
//
//    private void compactExpectedAndActual() {
//        findCommonPrefixAndSuffix();
//        compactExpected = compactString(expected);
//        compactActual = compactString(actual);
//    }
//
//    private void findCommonPrefixAndSuffix() {
//        findCommonPrefix();
//        suffixLength = 0;
//        for (; !suffixOverlapsPrefix(suffixLength); suffixLength++) {
//            if (charFromEnd(expected, suffixLength) !=
//                    charFromEnd(actual, suffixLength))
//                break;
//        }
//    }
//
//    private char charFromEnd(String s, int i) {
//        return s.charAt(s.length() - i - 1);
//    }
//
//    private boolean suffixOverlapsPrefix(int suffixLength) {
//        return actual.length() - suffixLength <= prefixLength ||
//                expected.length() - suffixLength <= prefixLength;
//    }
//
//    private void findCommonPrefix() {
//        prefixLength = 0;
//        int end = Math.min(expected.length(), actual.length());
//        for (; prefixLength < end; prefixLength++)
//            if (expected.charAt(prefixLength) != actual.charAt(prefixLength))
//                break;
//    }
//
//    private int findCommonSuffix(int prefixIndex) {
//        int expectedSuffix = expected.length() - 1;
//        int actualSuffix = actual.length() - 1;
//        for (; actualSuffix >= prefixIndex && expectedSuffix >= prefixIndex;
//             actualSuffix--, expectedSuffix--) {
//            if (expected.charAt(expectedSuffix) != actual.charAt(actualSuffix))
//                break;
//        }
//        return expected.length() - expectedSuffix;
//    }
//
//    private String compactString(String source) {
//        return
//                computeCommonPrefix() +
//                        DELTA_START +
//                        source.substring(prefixLength, source.length() - suffixLength) +
//                        DELTA_END +
//                        computeCommonSuffix();
//    }
//
//    private String computeCommonSuffix() {
//        int end = Math.min(expected.length() - suffixLength +
//                contextLength, expected.length()
//        );
//        return
//                expected.substring(expected.length() - suffixLength, end) +
//                        (expected.length() - suffixLength <
//                                expected.length() - contextLength ?
//                                ELLIPSIS : "");
//    }
//}