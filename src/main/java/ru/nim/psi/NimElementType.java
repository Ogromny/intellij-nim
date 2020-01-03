package ru.nim.psi;

import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import ru.nim.NimLanguage;

public class NimElementType extends IElementType {
    public NimElementType(@NotNull @NonNls String debugName) {
        super(debugName, NimLanguage.INSTANCE);
    }
}
