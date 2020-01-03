package ru.nim;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import ru.nim.psi.NimTypes;
import com.intellij.psi.TokenType;

%%

%class NimLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType

%{
    int block_comment_depth = 0;
%}

NEW_LINE = \n|\r|\r\n
WHITE_SPACE = [ \t\f]

LETTER = [A-Za-z\u0080-\u00ff]
DIGIT = [0-9]
IDENTIFIER = {LETTER} ("_"? ({LETTER} | {DIGIT}))*

STR_LIT = \" ([^\\\"]|((\\p)|(\\r)|(\\c)|(\\n)|(\\n)|(\\l)|(\\f)|(\\t)|(\\v)|(\\\\)|(\\\")|(\\\')|(\\[0-9])|(\\a)|(\\b)|(\\e)|(\\x[0-9A-Fa-f]{2,2})|(\\u[0-9A-Fa-f]{4,4})|(\\u\{[0-9A-Fa-f]{1,8}\})))* \"

COMMENT = \#[^\r\n\[]*

%state STATE_BLOCK_COMMENT

%%

<YYINITIAL> {
    {WHITE_SPACE}+              {return TokenType.WHITE_SPACE;}
    "#["                        {block_comment_depth = 0; yypushback(2); yybegin(STATE_BLOCK_COMMENT);}
    {COMMENT}                   {return NimTypes.COMMENT;}
    {NEW_LINE}+                 {return NimTypes.NEW_LINE;}
    "proc"                      {return NimTypes.KW_PROC;}
}
<STATE_BLOCK_COMMENT> {
    "#["                        {block_comment_depth++;}
    "#]"                        {if (--block_comment_depth == 0) {yybegin(YYINITIAL); zzStartRead = -1; return NimTypes.BLOCK_COMMENT;}}
    <<EOF>>                     {yybegin(YYINITIAL); return NimTypes.BLOCK_COMMENT;}
    [^]                         {}
}

//<YYINITIAL> {WHITE_SPACE}               {return TokenType.WHITE_SPACE;}
//<YYINITIAL> {NEW_LINE}                  {return NimTypes.NEW_LINE;}
//<YYINITIAL> {COMMENT}       {return NimTypes.COMMENT;}
//<YYINITIAL> "addr"          {return NimTypes.KW_ADDR;}
//<YYINITIAL> "and"           {return NimTypes.KW_AND;}
//<YYINITIAL> "as"            {return NimTypes.KW_AS;}
//<YYINITIAL> "asm"           {return NimTypes.KW_ASM;}
//<YYINITIAL> "bind"          {return NimTypes.KW_BIND;}
//<YYINITIAL> "block"         {return NimTypes.KW_BLOCK;}
//<YYINITIAL> "break"         {return NimTypes.KW_BREAK;}
//<YYINITIAL> "case"          {return NimTypes.KW_CASE;}
//<YYINITIAL> "cast"          {return NimTypes.KW_CAST;}
//<YYINITIAL> "concept"       {return NimTypes.KW_CONCEPT;}
//<YYINITIAL> "const"         {return NimTypes.KW_CONST;}
//<YYINITIAL> "continue"      {return NimTypes.KW_CONTINUE;}
//<YYINITIAL> "converter"     {return NimTypes.KW_CONVERTER;}
//<YYINITIAL> "defer"         {return NimTypes.KW_DEFER;}
//<YYINITIAL> "discard"       {return NimTypes.KW_DISCARD;}
//<YYINITIAL> "distinct"      {return NimTypes.KW_DISTINCT;}
//<YYINITIAL> "div"           {return NimTypes.KW_DIV;}
//<YYINITIAL> "do"            {return NimTypes.KW_DO;}
//<YYINITIAL> "elif"          {return NimTypes.KW_ELIF;}
//<YYINITIAL> "else"          {return NimTypes.KW_ELSE;}
//<YYINITIAL> "end"           {return NimTypes.KW_END;}
//<YYINITIAL> "enum"          {return NimTypes.KW_ENUM;}
//<YYINITIAL> "except"        {return NimTypes.KW_EXCEPT;}
//<YYINITIAL> "export"        {return NimTypes.KW_EXPORT;}
//<YYINITIAL> "finally"       {return NimTypes.KW_FINALLY;}
//<YYINITIAL> "for"           {return NimTypes.KW_FOR;}
//<YYINITIAL> "from"          {return NimTypes.KW_FROM;}
//<YYINITIAL> "func"          {return NimTypes.KW_FUNC;}
//<YYINITIAL> "if"            {return NimTypes.KW_IF;}
//<YYINITIAL> "import"        {return NimTypes.KW_IMPORT;}
//<YYINITIAL> "in"            {return NimTypes.KW_IN;}
//<YYINITIAL> "include"       {return NimTypes.KW_INCLUDE;}
//<YYINITIAL> "interface"     {return NimTypes.KW_INTERFACE;}
//<YYINITIAL> "is"            {return NimTypes.KW_IS;}
//<YYINITIAL> "isnot"         {return NimTypes.KW_ISNOT;}
//<YYINITIAL> "iterator"      {return NimTypes.KW_ITERATOR;}
//<YYINITIAL> "let"           {return NimTypes.KW_LET;}
//<YYINITIAL> "macro"         {return NimTypes.KW_MACRO;}
//<YYINITIAL> "method"        {return NimTypes.KW_METHOD;}
//<YYINITIAL> "mixin"         {return NimTypes.KW_MIXIN;}
//<YYINITIAL> "mod"           {return NimTypes.KW_MOD;}
//<YYINITIAL> "nil"           {return NimTypes.KW_NIL;}
//<YYINITIAL> "not"           {return NimTypes.KW_NOT;}
//<YYINITIAL> "notin"         {return NimTypes.KW_NOTIN;}
//<YYINITIAL> "object"        {return NimTypes.KW_OBJECT;}
//<YYINITIAL> "of"            {return NimTypes.KW_OF;}
//<YYINITIAL> "or"            {return NimTypes.KW_OR;}
//<YYINITIAL> "out"           {return NimTypes.KW_OUT;}
//<YYINITIAL> "proc"          {return NimTypes.KW_PROC;}
//<YYINITIAL> "ptr"           {return NimTypes.KW_PTR;}
//<YYINITIAL> "raise"         {return NimTypes.KW_RAISE;}
//<YYINITIAL> "ref"           {return NimTypes.KW_REF;}
//<YYINITIAL> "return"        {return NimTypes.KW_RETURN;}
//<YYINITIAL> "shl"           {return NimTypes.KW_SHL;}
//<YYINITIAL> "shr"           {return NimTypes.KW_SHR;}
//<YYINITIAL> "static"        {return NimTypes.KW_STATIC;}
//<YYINITIAL> "template"      {return NimTypes.KW_TEMPLATE;}
//<YYINITIAL> "try"           {return NimTypes.KW_TRY;}
//<YYINITIAL> "tuple"         {return NimTypes.KW_TUPLE;}
//<YYINITIAL> "type"          {return NimTypes.KW_TYPE;}
//<YYINITIAL> "using"         {return NimTypes.KW_USING;}
//<YYINITIAL> "var"           {return NimTypes.KW_VAR;}
//<YYINITIAL> "when"          {return NimTypes.KW_WHEN;}
//<YYINITIAL> "while"         {return NimTypes.KW_WHILE;}
//<YYINITIAL> "xor"           {return NimTypes.KW_XOR;}
//<YYINITIAL> "yield"         {return NimTypes.KW_YIELD;}
//<YYINITIAL> {IDENTIFIER}                {return NimTypes.IDENTIFIER;}
//<YYINITIAL> {STR_LIT}                   {return NimTypes.STR_LIT;}

[^]                                     {return TokenType.BAD_CHARACTER;}
