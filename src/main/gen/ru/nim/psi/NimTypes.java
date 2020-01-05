// This is a generated file. Not intended for manual editing.
package ru.nim.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import ru.nim.psi.impl.*;

public interface NimTypes {

  IElementType PROC = new NimElementType("PROC");

  IElementType BIN_LIT = new NimTokenType("BIN_LIT");
  IElementType BLOCK_COMMENT = new NimTokenType("BLOCK_COMMENT");
  IElementType COMMENT = new NimTokenType("COMMENT");
  IElementType DEC_LIT = new NimTokenType("DEC_LIT");
  IElementType FLOAT32_LIT = new NimTokenType("FLOAT32_LIT");
  IElementType FLOAT64_LIT = new NimTokenType("FLOAT64_LIT");
  IElementType FLOAT_LIT = new NimTokenType("FLOAT_LIT");
  IElementType HEX_LIT = new NimTokenType("HEX_LIT");
  IElementType INT16_LIT = new NimTokenType("INT16_LIT");
  IElementType INT32_LIT = new NimTokenType("INT32_LIT");
  IElementType INT64_LIT = new NimTokenType("INT64_LIT");
  IElementType INT8_LIT = new NimTokenType("INT8_LIT");
  IElementType KW_PROC = new NimTokenType("KW_PROC");
  IElementType NEW_LINE = new NimTokenType("NEW_LINE");
  IElementType OCT_LIT = new NimTokenType("OCT_LIT");
  IElementType RSTR_LIT = new NimTokenType("RSTR_LIT");
  IElementType STR_LIT = new NimTokenType("STR_LIT");
  IElementType TRIPLESTR_LIT = new NimTokenType("TRIPLESTR_LIT");
  IElementType UINT16_LIT = new NimTokenType("UINT16_LIT");
  IElementType UINT32_LIT = new NimTokenType("UINT32_LIT");
  IElementType UINT64_LIT = new NimTokenType("UINT64_LIT");
  IElementType UINT8_LIT = new NimTokenType("UINT8_LIT");
  IElementType UINT_LIT = new NimTokenType("UINT_LIT");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == PROC) {
        return new NimProcImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
