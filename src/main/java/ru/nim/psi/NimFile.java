package ru.nim.psi;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.nim.NimFileType;
import ru.nim.NimLanguage;

import javax.swing.*;

public class NimFile extends PsiFileBase {
    public NimFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, NimLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return NimFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "Nim File";
    }

    @Nullable
    @Override
    public Icon getIcon(int flags) {
        return super.getIcon(flags);
    }
}
