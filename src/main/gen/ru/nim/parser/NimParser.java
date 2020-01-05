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
  // (proc|COMMENT|BLOCK_COMMENT|NEW_LINE|STR_LIT|TRIPLESTR_LIT|RSTR_LIT|HEX_LIT|DEC_LIT|OCT_LIT|BIN_LIT
  //             |INT8_LIT|INT16_LIT|INT32_LIT|INT64_LIT|UINT_LIT|UINT8_LIT|UINT16_LIT|UINT32_LIT|UINT64_LIT|FLOAT_LIT
  //             |FLOAT32_LIT|FLOAT64_LIT)*
  static boolean nimFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nimFile")) return false;
    while (true) {
      int c = current_position_(b);
      if (!nimFile_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "nimFile", c)) break;
    }
    return true;
  }

  // proc|COMMENT|BLOCK_COMMENT|NEW_LINE|STR_LIT|TRIPLESTR_LIT|RSTR_LIT|HEX_LIT|DEC_LIT|OCT_LIT|BIN_LIT
  //             |INT8_LIT|INT16_LIT|INT32_LIT|INT64_LIT|UINT_LIT|UINT8_LIT|UINT16_LIT|UINT32_LIT|UINT64_LIT|FLOAT_LIT
  //             |FLOAT32_LIT|FLOAT64_LIT
  private static boolean nimFile_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nimFile_0")) return false;
    boolean r;
    r = proc(b, l + 1);
    if (!r) r = consumeToken(b, COMMENT);
    if (!r) r = consumeToken(b, BLOCK_COMMENT);
    if (!r) r = consumeToken(b, NEW_LINE);
    if (!r) r = consumeToken(b, STR_LIT);
    if (!r) r = consumeToken(b, TRIPLESTR_LIT);
    if (!r) r = consumeToken(b, RSTR_LIT);
    if (!r) r = consumeToken(b, HEX_LIT);
    if (!r) r = consumeToken(b, DEC_LIT);
    if (!r) r = consumeToken(b, OCT_LIT);
    if (!r) r = consumeToken(b, BIN_LIT);
    if (!r) r = consumeToken(b, INT8_LIT);
    if (!r) r = consumeToken(b, INT16_LIT);
    if (!r) r = consumeToken(b, INT32_LIT);
    if (!r) r = consumeToken(b, INT64_LIT);
    if (!r) r = consumeToken(b, UINT_LIT);
    if (!r) r = consumeToken(b, UINT8_LIT);
    if (!r) r = consumeToken(b, UINT16_LIT);
    if (!r) r = consumeToken(b, UINT32_LIT);
    if (!r) r = consumeToken(b, UINT64_LIT);
    if (!r) r = consumeToken(b, FLOAT_LIT);
    if (!r) r = consumeToken(b, FLOAT32_LIT);
    if (!r) r = consumeToken(b, FLOAT64_LIT);
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
