package ru.nim;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.tree.IElementType;
import com.thaiopensource.xml.dtd.om.Def;
import org.jetbrains.annotations.NotNull;
import ru.nim.psi.NimTypes;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public class NimSyntaxHighlighter extends SyntaxHighlighterBase {
    public static final TextAttributesKey COMMENT = createTextAttributesKey("NIM_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
    public static final TextAttributesKey BLOCK_COMMENT = createTextAttributesKey("NIM_BLOCK_COMMENT", DefaultLanguageHighlighterColors.BLOCK_COMMENT);

    private static final TextAttributesKey[] COMMENT_KEYS = new TextAttributesKey[]{COMMENT, BLOCK_COMMENT};
    private static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];

    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new NimLexerAdapter();
    }

    @NotNull
    @Override
    public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
        if (tokenType.equals(NimTypes.COMMENT) || tokenType.equals(NimTypes.BLOCK_COMMENT)) {
            return COMMENT_KEYS;
        }

        return EMPTY_KEYS;
    }
}