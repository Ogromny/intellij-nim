package ru.nim.psi;

import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import ru.nim.NimLanguage;

public class NimTokenType extends IElementType {
    public NimTokenType(@NotNull @NonNls String debugName) {
        super(debugName, NimLanguage.INSTANCE);
    }

    @Override
    public String toString() {
        return "NimTokenType." + super.toString();
    }
}
