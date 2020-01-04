// This is a generated file. Not intended for manual editing.
package ru.nim.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import ru.nim.psi.impl.*;

public interface NimTypes {

  IElementType PROC = new NimElementType("PROC");

  IElementType BLOCK_COMMENT = new NimTokenType("BLOCK_COMMENT");
  IElementType COMMENT = new NimTokenType("COMMENT");
  IElementType KW_PROC = new NimTokenType("KW_PROC");
  IElementType NEW_LINE = new NimTokenType("NEW_LINE");
  IElementType TRIPLESTR_LIT = new NimTokenType("TRIPLESTR_LIT");

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
