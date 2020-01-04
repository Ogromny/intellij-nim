// This is a generated file. Not intended for manual editing.
package ru.nim.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static ru.nim.psi.NimTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class NimParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return nimFile(b, l + 1);
  }

  /* ********************************************************** */
  // (proc|COMMENT|BLOCK_COMMENT|NEW_LINE|TRIPLESTR_LIT)*
  static boolean nimFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nimFile")) return false;
    while (true) {
      int c = current_position_(b);
      if (!nimFile_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "nimFile", c)) break;
    }
    return true;
  }

  // proc|COMMENT|BLOCK_COMMENT|NEW_LINE|TRIPLESTR_LIT
  private static boolean nimFile_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nimFile_0")) return false;
    boolean r;
    r = proc(b, l + 1);
    if (!r) r = consumeToken(b, COMMENT);
    if (!r) r = consumeToken(b, BLOCK_COMMENT);
    if (!r) r = consumeToken(b, NEW_LINE);
    if (!r) r = consumeToken(b, TRIPLESTR_LIT);
    return r;
  }

  /* ********************************************************** */
  // KW_PROC ":"
  public static boolean proc(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "proc")) return false;
    if (!nextTokenIs(b, KW_PROC)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_PROC);
    r = r && consumeToken(b, ":");
    exit_section_(b, m, PROC, r);
    return r;
  }

}
