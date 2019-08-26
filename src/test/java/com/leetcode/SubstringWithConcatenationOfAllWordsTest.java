package com.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author carl
 */
public class SubstringWithConcatenationOfAllWordsTest {
    SubstringWithConcatenationOfAllWords sub = new SubstringWithConcatenationOfAllWords();

    @Test
    public void test() {
        List<Integer> exp = Arrays.asList(0, 9);
        List<Integer> res = sub.findSubstring("barfoothefoobarman", new String[]{"foo", "bar"});
        assertTrue(res.size() == 2);
        assertTrue(() -> {
            for (int i = 0; i < res.size(); i++) {
                if (!exp.get(i).equals(res.get(i))) {
                    return false;
                }
            }
            return true;
        });
    }

    @Test
    public void testExists() {
        List<Integer> exp = Arrays.asList(6, 9, 12);
        List<Integer> res = sub.findSubstring("barfoofoobarthefoobarman", new String[]{"bar", "foo", "the"});
        assertTrue(res.size() == 3);
        assertTrue(() -> {
            for (int i = 0; i < res.size(); i++) {
                if (!exp.get(i).equals(res.get(i))) {
                    return false;
                }
            }
            return true;
        });
    }

    @Test
    public void testWhenNonExists() {
        List<Integer> exp = Arrays.asList();
        List<Integer> res = sub.findSubstring("wordgoodgoodgoodbestword", new String[]{"word", "good", "best", "word"});
        assertTrue(res.isEmpty());
    }

    @Test
    public void testLarge() {
        List<Integer> exp = Arrays.asList(935);
        List<Integer> res = sub.findSubstring("pjzkrkevzztxductzzxmxsvwjkxpvukmfjywwetvfnujhweiybwvvsrfequzkhossmootkmyxgjgfordrpapjuunmqnxxdrqrfgkrsjqbszgiqlcfnrpjlcwdrvbumtotzylshdvccdmsqoadfrpsvnwpizlwszrtyclhgilklydbmfhuywotjmktnwrfvizvnmfvvqfiokkdprznnnjycttprkxpuykhmpchiksyucbmtabiqkisgbhxngmhezrrqvayfsxauampdpxtafniiwfvdufhtwajrbkxtjzqjnfocdhekumttuqwovfjrgulhekcpjszyynadxhnttgmnxkduqmmyhzfnjhducesctufqbumxbamalqudeibljgbspeotkgvddcwgxidaiqcvgwykhbysjzlzfbupkqunuqtraxrlptivshhbihtsigtpipguhbhctcvubnhqipncyxfjebdnjyetnlnvmuxhzsdahkrscewabejifmxombiamxvauuitoltyymsarqcuuoezcbqpdaprxmsrickwpgwpsoplhugbikbkotzrtqkscekkgwjycfnvwfgdzogjzjvpcvixnsqsxacfwndzvrwrycwxrcismdhqapoojegggkocyrdtkzmiekhxoppctytvphjynrhtcvxcobxbcjjivtfjiwmduhzjokkbctweqtigwfhzorjlkpuuliaipbtfldinyetoybvugevwvhhhweejogrghllsouipabfafcxnhukcbtmxzshoyyufjhzadhrelweszbfgwpkzlwxkogyogutscvuhcllphshivnoteztpxsaoaacgxyaztuixhunrowzljqfqrahosheukhahhbiaxqzfmmwcjxountkevsvpbzjnilwpoermxrtlfroqoclexxisrdhvfsindffslyekrzwzqkpeocilatftymodgztjgybtyheqgcpwogdcjlnlesefgvimwbxcbzvaibspdjnrpqtyeilkcspknyylbwndvkffmzuriilxagyerjptbgeqgebiaqnvdubrtxibhvakcyotkfonmseszhczapxdlauexehhaireihxsplgdgmxfvaevrbadbwjbdrkfbbjjkgcztkcbwagtcnrtqryuqixtzhaakjlurnumzyovawrcjiwabuwretmdamfkxrgqgcdgbrdbnugzecbgyxxdqmisaqcyjkqrntxqmdrczxbebemcblftxplafnyoxqimkhcykwamvdsxjezkpgdpvopddptdfbprjustquhlazkjfluxrzopqdstulybnqvyknrchbphcarknnhhovweaqawdyxsqsqahkepluypwrzjegqtdoxfgzdkydeoxvrfhxusrujnmjzqrrlxglcmkiykldbiasnhrjbjekystzilrwkzhontwmehrfsrzfaqrbbxncphbzuuxeteshyrveamjsfiaharkcqxefghgceeixkdgkuboupxnwhnfigpkwnqdvzlydpidcljmflbccarbiegsmweklwngvygbqpescpeichmfidgsjmkvkofvkuehsmkkbocgejoiqcnafvuokelwuqsgkyoekaroptuvekfvmtxtqshcwsztkrzwrpabqrrhnlerxjojemcxel",
                new String[]{"dhvf", "sind", "ffsl", "yekr", "zwzq", "kpeo", "cila", "tfty", "modg", "ztjg", "ybty", "heqg", "cpwo", "gdcj", "lnle", "sefg", "vimw", "bxcb"});
        assertTrue(res.size() == exp.size());
        assertTrue(() -> {
            for (int i = 0; i < res.size(); i++) {
                if (!exp.get(i).equals(res.get(i))) {
                    return false;
                }
            }
            return true;
        });
    }
}
