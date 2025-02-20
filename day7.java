//Maximum Number of Words Found in Sentences

class Solution {
    public int mostWordsFound(String[] sentences, int i, String str, int max) {
        if (i >= sentences.length) {
            return max;
        }
        str = str + ' ';
        int count = 0;
        for (int j = 0; j < str.length(); j++) {
            if (str.charAt(j) == ' ') {
                count = count + 1;
            }
        }
        if (count > max) {
            max = count;
        }
        return mostWordsFound(sentences, i + 1, i + 1 < sentences.length ? sentences[i + 1] : "", max);

    }

    public int mostWordsFound(String[] sentences) {
        return mostWordsFound(sentences, 0, sentences[0], 0);
    }
}
