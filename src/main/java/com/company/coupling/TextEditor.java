package com.company.coupling;

public class TextEditor {

    private SpellChecker spellChecker;

    public TextEditor() {
        this.spellChecker = new SpellChecker();
    }
}
