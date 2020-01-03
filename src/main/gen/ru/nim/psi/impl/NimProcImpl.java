// This is a generated file. Not intended for manual editing.
package ru.nim.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static ru.nim.psi.NimTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import ru.nim.psi.*;

public class NimProcImpl extends ASTWrapperPsiElement implements NimProc {

  public NimProcImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull NimVisitor visitor) {
    visitor.visitProc(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof NimVisitor) accept((NimVisitor)visitor);
    else super.accept(visitor);
  }

}
