/* SQLPPTokenManager.java */
/* Generated By:JavaCC: Do not edit this line. SQLPPTokenManager.java */
package edu.uci.ics.asterix.sqlpp.parser;
import java.util.List;
import java.util.ArrayList;
import edu.uci.ics.asterix.sqlpp.base.AbstractStatement;
import edu.uci.ics.asterix.sqlpp.statement.SQLPPQuery;
import edu.uci.ics.asterix.sqlpp.base.AbstractExpression;
import edu.uci.ics.asterix.sqlpp.expression.SQLPPOperatorExpr;
import edu.uci.ics.asterix.sqlpp.expression.SQLPPUnaryExpr;
import edu.uci.ics.asterix.sqlpp.expression.SQLPPUnaryExpr.Sign;
import edu.uci.ics.asterix.sqlpp.expression.SQLPPSFWExpression;
import edu.uci.ics.asterix.sqlpp.expression.SQLPPValueExpression;
import edu.uci.ics.asterix.sqlpp.expression.SQLPPNamedValueExpression;
import edu.uci.ics.asterix.sqlpp.expression.SQLPPSelectItemExpression;
import edu.uci.ics.asterix.sqlpp.expression.SQLPPFromInnerJoin;
import edu.uci.ics.asterix.sqlpp.expression.SQLPPFromOuterJoin;
import edu.uci.ics.asterix.sqlpp.expression.SQLPPFromOuterJoin.OuterJoinType;
import edu.uci.ics.asterix.sqlpp.expression.SQLPPFromItem;
import edu.uci.ics.asterix.sqlpp.expression.SQLPPFromSingle;
import edu.uci.ics.asterix.sqlpp.expression.SQLPPAliasExpression;
import edu.uci.ics.asterix.sqlpp.expression.SQLPPVariableRef;
import edu.uci.ics.asterix.sqlpp.expression.Identifier;
import edu.uci.ics.asterix.sqlpp.base.AbstractValue;
import edu.uci.ics.asterix.sqlpp.value.DoubleValue;
import edu.uci.ics.asterix.sqlpp.value.FalseValue;
import edu.uci.ics.asterix.sqlpp.value.FloatValue;
import edu.uci.ics.asterix.sqlpp.value.IntegerValue;
import edu.uci.ics.asterix.sqlpp.value.LongValue;
import edu.uci.ics.asterix.sqlpp.value.MissingValue;
import edu.uci.ics.asterix.sqlpp.value.StringValue;
import edu.uci.ics.asterix.sqlpp.value.NullValue;
import edu.uci.ics.asterix.sqlpp.value.TrueValue;
import edu.uci.ics.asterix.sqlpp.parser.AbstractParser;
import edu.uci.ics.asterix.sqlpp.base.AbstractClause;
import edu.uci.ics.asterix.sqlpp.clause.SelectClause;
import edu.uci.ics.asterix.sqlpp.clause.FromClause;
import edu.uci.ics.asterix.sqlpp.clause.WhereClause;

/** Token Manager. */
@SuppressWarnings("unused")public class SQLPPTokenManager implements SQLPPConstants {

  /** Debug output. */
  public  java.io.PrintStream debugStream = System.out;
  /** Set debug output. */
  public  void setDebugStream(java.io.PrintStream ds) { debugStream = ds; }
private final int jjStopStringLiteralDfa_0(int pos, long active0, long active1){
   switch (pos)
   {
      case 0:
         if ((active0 & 0x2000L) != 0L)
            return 46;
         if ((active0 & 0x3d800004ffeL) != 0L)
         {
            jjmatchedKind = 58;
            return 26;
         }
         if ((active0 & 0x2000000L) != 0L)
            return 54;
         return -1;
      case 1:
         if ((active0 & 0x1000000050L) != 0L)
            return 26;
         if ((active0 & 0x3c800004faeL) != 0L)
         {
            jjmatchedKind = 58;
            jjmatchedPos = 1;
            return 26;
         }
         return -1;
      case 2:
         if ((active0 & 0x3c000004faeL) != 0L)
         {
            jjmatchedKind = 58;
            jjmatchedPos = 2;
            return 26;
         }
         if ((active0 & 0x800000000L) != 0L)
            return 26;
         return -1;
      case 3:
         if ((active0 & 0xc000004a24L) != 0L)
            return 26;
         if ((active0 & 0x3000000058aL) != 0L)
         {
            jjmatchedKind = 58;
            jjmatchedPos = 3;
            return 26;
         }
         return -1;
      case 4:
         if ((active0 & 0x10000000588L) != 0L)
            return 26;
         if ((active0 & 0x20000000002L) != 0L)
         {
            jjmatchedKind = 58;
            jjmatchedPos = 4;
            return 26;
         }
         return -1;
      case 5:
         if ((active0 & 0x20000000000L) != 0L)
         {
            jjmatchedKind = 58;
            jjmatchedPos = 5;
            return 26;
         }
         if ((active0 & 0x2L) != 0L)
            return 26;
         return -1;
      default :
         return -1;
   }
}
private final int jjStartNfa_0(int pos, long active0, long active1){
   return jjMoveNfa_0(jjStopStringLiteralDfa_0(pos, active0, active1), pos + 1);
}
private int jjStopAtPos(int pos, int kind)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   return pos + 1;
}
private int jjMoveStringLiteralDfa0_0(){
   switch(curChar)
   {
      case 33:
         return jjMoveStringLiteralDfa1_0(0x100000000L);
      case 37:
         return jjStopAtPos(0, 16);
      case 40:
         return jjStopAtPos(0, 19);
      case 41:
         return jjStopAtPos(0, 20);
      case 42:
         return jjStopAtPos(0, 17);
      case 43:
         return jjStopAtPos(0, 18);
      case 44:
         return jjStopAtPos(0, 24);
      case 45:
         return jjStopAtPos(0, 15);
      case 46:
         return jjStartNfaWithStates_0(0, 25, 54);
      case 47:
         return jjStartNfaWithStates_0(0, 13, 46);
      case 58:
         jjmatchedKind = 23;
         return jjMoveStringLiteralDfa1_0(0x400000000L);
      case 59:
         return jjStopAtPos(0, 66);
      case 60:
         jjmatchedKind = 27;
         return jjMoveStringLiteralDfa1_0(0x20000000L);
      case 61:
         return jjStopAtPos(0, 31);
      case 62:
         jjmatchedKind = 28;
         return jjMoveStringLiteralDfa1_0(0x40000000L);
      case 63:
         return jjStopAtPos(0, 26);
      case 91:
         return jjStopAtPos(0, 21);
      case 93:
         return jjStopAtPos(0, 22);
      case 94:
         return jjStopAtPos(0, 12);
      case 65:
      case 97:
         return jjMoveStringLiteralDfa1_0(0x800000010L);
      case 70:
      case 102:
         return jjMoveStringLiteralDfa1_0(0x10000000804L);
      case 73:
      case 105:
         return jjMoveStringLiteralDfa1_0(0x4080L);
      case 74:
      case 106:
         return jjMoveStringLiteralDfa1_0(0x20L);
      case 76:
      case 108:
         return jjMoveStringLiteralDfa1_0(0x200L);
      case 77:
      case 109:
         return jjMoveStringLiteralDfa1_0(0x20000000000L);
      case 78:
      case 110:
         return jjMoveStringLiteralDfa1_0(0x4000000000L);
      case 79:
      case 111:
         return jjMoveStringLiteralDfa1_0(0x1000000140L);
      case 82:
      case 114:
         return jjMoveStringLiteralDfa1_0(0x400L);
      case 83:
      case 115:
         return jjMoveStringLiteralDfa1_0(0x2L);
      case 84:
      case 116:
         return jjMoveStringLiteralDfa1_0(0x8000000000L);
      case 87:
      case 119:
         return jjMoveStringLiteralDfa1_0(0x8L);
      case 126:
         return jjMoveStringLiteralDfa1_0(0x200000000L);
      default :
         return jjMoveNfa_0(0, 0);
   }
}
private int jjMoveStringLiteralDfa1_0(long active0){
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(0, active0, 0L);
      return 1;
   }
   switch(curChar)
   {
      case 61:
         if ((active0 & 0x20000000L) != 0L)
            return jjStopAtPos(1, 29);
         else if ((active0 & 0x40000000L) != 0L)
            return jjStopAtPos(1, 30);
         else if ((active0 & 0x100000000L) != 0L)
            return jjStopAtPos(1, 32);
         else if ((active0 & 0x200000000L) != 0L)
            return jjStopAtPos(1, 33);
         else if ((active0 & 0x400000000L) != 0L)
            return jjStopAtPos(1, 34);
         break;
      case 65:
      case 97:
         return jjMoveStringLiteralDfa2_0(active0, 0x10000000000L);
      case 68:
      case 100:
         return jjMoveStringLiteralDfa2_0(active0, 0x4000L);
      case 69:
      case 101:
         return jjMoveStringLiteralDfa2_0(active0, 0x202L);
      case 72:
      case 104:
         return jjMoveStringLiteralDfa2_0(active0, 0x8L);
      case 73:
      case 105:
         return jjMoveStringLiteralDfa2_0(active0, 0x20000000400L);
      case 78:
      case 110:
         if ((active0 & 0x40L) != 0L)
            return jjStartNfaWithStates_0(1, 6, 26);
         return jjMoveStringLiteralDfa2_0(active0, 0x800000080L);
      case 79:
      case 111:
         return jjMoveStringLiteralDfa2_0(active0, 0x20L);
      case 82:
      case 114:
         if ((active0 & 0x1000000000L) != 0L)
            return jjStartNfaWithStates_0(1, 36, 26);
         return jjMoveStringLiteralDfa2_0(active0, 0x8000000004L);
      case 83:
      case 115:
         if ((active0 & 0x10L) != 0L)
            return jjStartNfaWithStates_0(1, 4, 26);
         break;
      case 85:
      case 117:
         return jjMoveStringLiteralDfa2_0(active0, 0x4000000900L);
      default :
         break;
   }
   return jjStartNfa_0(0, active0, 0L);
}
private int jjMoveStringLiteralDfa2_0(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(0, old0, 0L);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(1, active0, 0L);
      return 2;
   }
   switch(curChar)
   {
      case 68:
      case 100:
         if ((active0 & 0x800000000L) != 0L)
            return jjStartNfaWithStates_0(2, 35, 26);
         break;
      case 69:
      case 101:
         return jjMoveStringLiteralDfa3_0(active0, 0x8L);
      case 70:
      case 102:
         return jjMoveStringLiteralDfa3_0(active0, 0x200L);
      case 71:
      case 103:
         return jjMoveStringLiteralDfa3_0(active0, 0x400L);
      case 73:
      case 105:
         return jjMoveStringLiteralDfa3_0(active0, 0x4020L);
      case 76:
      case 108:
         return jjMoveStringLiteralDfa3_0(active0, 0x14000000802L);
      case 78:
      case 110:
         return jjMoveStringLiteralDfa3_0(active0, 0x80L);
      case 79:
      case 111:
         return jjMoveStringLiteralDfa3_0(active0, 0x4L);
      case 83:
      case 115:
         return jjMoveStringLiteralDfa3_0(active0, 0x20000000000L);
      case 84:
      case 116:
         return jjMoveStringLiteralDfa3_0(active0, 0x100L);
      case 85:
      case 117:
         return jjMoveStringLiteralDfa3_0(active0, 0x8000000000L);
      default :
         break;
   }
   return jjStartNfa_0(1, active0, 0L);
}
private int jjMoveStringLiteralDfa3_0(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(1, old0, 0L);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(2, active0, 0L);
      return 3;
   }
   switch(curChar)
   {
      case 69:
      case 101:
         if ((active0 & 0x8000000000L) != 0L)
            return jjStartNfaWithStates_0(3, 39, 26);
         return jjMoveStringLiteralDfa4_0(active0, 0x182L);
      case 72:
      case 104:
         return jjMoveStringLiteralDfa4_0(active0, 0x400L);
      case 76:
      case 108:
         if ((active0 & 0x800L) != 0L)
            return jjStartNfaWithStates_0(3, 11, 26);
         else if ((active0 & 0x4000000000L) != 0L)
            return jjStartNfaWithStates_0(3, 38, 26);
         break;
      case 77:
      case 109:
         if ((active0 & 0x4L) != 0L)
            return jjStartNfaWithStates_0(3, 2, 26);
         break;
      case 78:
      case 110:
         if ((active0 & 0x20L) != 0L)
            return jjStartNfaWithStates_0(3, 5, 26);
         break;
      case 82:
      case 114:
         return jjMoveStringLiteralDfa4_0(active0, 0x8L);
      case 83:
      case 115:
         return jjMoveStringLiteralDfa4_0(active0, 0x30000000000L);
      case 84:
      case 116:
         if ((active0 & 0x200L) != 0L)
            return jjStartNfaWithStates_0(3, 9, 26);
         break;
      case 86:
      case 118:
         if ((active0 & 0x4000L) != 0L)
            return jjStartNfaWithStates_0(3, 14, 26);
         break;
      default :
         break;
   }
   return jjStartNfa_0(2, active0, 0L);
}
private int jjMoveStringLiteralDfa4_0(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(2, old0, 0L);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(3, active0, 0L);
      return 4;
   }
   switch(curChar)
   {
      case 67:
      case 99:
         return jjMoveStringLiteralDfa5_0(active0, 0x2L);
      case 69:
      case 101:
         if ((active0 & 0x8L) != 0L)
            return jjStartNfaWithStates_0(4, 3, 26);
         else if ((active0 & 0x10000000000L) != 0L)
            return jjStartNfaWithStates_0(4, 40, 26);
         break;
      case 73:
      case 105:
         return jjMoveStringLiteralDfa5_0(active0, 0x20000000000L);
      case 82:
      case 114:
         if ((active0 & 0x80L) != 0L)
            return jjStartNfaWithStates_0(4, 7, 26);
         else if ((active0 & 0x100L) != 0L)
            return jjStartNfaWithStates_0(4, 8, 26);
         break;
      case 84:
      case 116:
         if ((active0 & 0x400L) != 0L)
            return jjStartNfaWithStates_0(4, 10, 26);
         break;
      default :
         break;
   }
   return jjStartNfa_0(3, active0, 0L);
}
private int jjMoveStringLiteralDfa5_0(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(3, old0, 0L);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(4, active0, 0L);
      return 5;
   }
   switch(curChar)
   {
      case 78:
      case 110:
         return jjMoveStringLiteralDfa6_0(active0, 0x20000000000L);
      case 84:
      case 116:
         if ((active0 & 0x2L) != 0L)
            return jjStartNfaWithStates_0(5, 1, 26);
         break;
      default :
         break;
   }
   return jjStartNfa_0(4, active0, 0L);
}
private int jjMoveStringLiteralDfa6_0(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(4, old0, 0L);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(5, active0, 0L);
      return 6;
   }
   switch(curChar)
   {
      case 71:
      case 103:
         if ((active0 & 0x20000000000L) != 0L)
            return jjStartNfaWithStates_0(6, 41, 26);
         break;
      default :
         break;
   }
   return jjStartNfa_0(5, active0, 0L);
}
private int jjStartNfaWithStates_0(int pos, int kind, int state)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) { return pos + 1; }
   return jjMoveNfa_0(state, pos + 1);
}
static final long[] jjbitVec0 = {
   0x0L, 0x0L, 0xffffffffffffffffL, 0xffffffffffffffffL
};
private int jjMoveNfa_0(int startState, int curPos)
{
   int startsAt = 0;
   jjnewStateCnt = 54;
   int i = 1;
   jjstateSet[0] = startState;
   int kind = 0x7fffffff;
   for (;;)
   {
      if (++jjround == 0x7fffffff)
         ReInitRounds();
      if (curChar < 64)
      {
         long l = 1L << curChar;
         do
         {
            switch(jjstateSet[--i])
            {
               case 46:
                  if (curChar == 47)
                  {
                     if (kind > 65)
                        kind = 65;
                     { jjCheckNAddStates(0, 2); }
                  }
                  if (curChar == 47)
                     { jjCheckNAddTwoStates(47, 48); }
                  break;
               case 54:
                  if ((0x3ff000000000000L & l) != 0L)
                     { jjCheckNAddTwoStates(44, 37); }
                  if ((0x3ff000000000000L & l) != 0L)
                  {
                     if (kind > 43)
                        kind = 43;
                     { jjCheckNAdd(43); }
                  }
                  break;
               case 0:
                  if ((0x3ff000000000000L & l) != 0L)
                  {
                     if (kind > 37)
                        kind = 37;
                     { jjCheckNAddStates(3, 11); }
                  }
                  else if ((0x201000000000L & l) != 0L)
                  {
                     if (kind > 47)
                        kind = 47;
                  }
                  else if (curChar == 47)
                     { jjAddStates(12, 13); }
                  else if (curChar == 46)
                     { jjCheckNAddTwoStates(43, 44); }
                  else if (curChar == 39)
                     { jjCheckNAddStates(14, 16); }
                  else if (curChar == 34)
                     { jjCheckNAddStates(17, 19); }
                  if (curChar == 36)
                     jjstateSet[jjnewStateCnt++] = 28;
                  break;
               case 1:
               case 5:
                  if (curChar == 34)
                     { jjCheckNAddStates(17, 19); }
                  break;
               case 2:
                  if ((0xfffffffbffffffffL & l) != 0L)
                     { jjCheckNAddStates(17, 19); }
                  break;
               case 3:
                  if (curChar == 34 && kind > 48)
                     kind = 48;
                  break;
               case 7:
                  if (curChar == 47)
                     { jjCheckNAddStates(17, 19); }
                  break;
               case 13:
               case 17:
                  if (curChar == 39)
                     { jjCheckNAddStates(14, 16); }
                  break;
               case 14:
                  if ((0xffffff7fffffffffL & l) != 0L)
                     { jjCheckNAddStates(14, 16); }
                  break;
               case 15:
                  if (curChar == 39 && kind > 48)
                     kind = 48;
                  break;
               case 19:
                  if (curChar == 47)
                     { jjCheckNAddStates(14, 16); }
                  break;
               case 26:
                  if ((0x3ff201000000000L & l) == 0L)
                     break;
                  if (kind > 58)
                     kind = 58;
                  jjstateSet[jjnewStateCnt++] = 26;
                  break;
               case 27:
                  if (curChar == 36)
                     jjstateSet[jjnewStateCnt++] = 28;
                  break;
               case 29:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 59)
                     kind = 59;
                  jjstateSet[jjnewStateCnt++] = 29;
                  break;
               case 30:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 37)
                     kind = 37;
                  { jjCheckNAddStates(3, 11); }
                  break;
               case 31:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 37)
                     kind = 37;
                  { jjCheckNAdd(31); }
                  break;
               case 32:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 43)
                     kind = 43;
                  { jjCheckNAdd(32); }
                  break;
               case 33:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 43)
                     kind = 43;
                  { jjCheckNAddTwoStates(33, 34); }
                  break;
               case 34:
                  if (curChar == 46)
                     { jjCheckNAdd(35); }
                  break;
               case 35:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 43)
                     kind = 43;
                  { jjCheckNAdd(35); }
                  break;
               case 36:
                  if ((0x3ff000000000000L & l) != 0L)
                     { jjCheckNAddTwoStates(36, 37); }
                  break;
               case 38:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 44)
                     kind = 44;
                  { jjCheckNAddTwoStates(38, 39); }
                  break;
               case 39:
                  if (curChar == 46)
                     { jjCheckNAdd(40); }
                  break;
               case 40:
                  if ((0x3ff000000000000L & l) != 0L)
                     { jjCheckNAddTwoStates(40, 37); }
                  break;
               case 41:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 45)
                     kind = 45;
                  { jjCheckNAdd(41); }
                  break;
               case 42:
                  if (curChar == 46)
                     { jjCheckNAddTwoStates(43, 44); }
                  break;
               case 43:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 43)
                     kind = 43;
                  { jjCheckNAdd(43); }
                  break;
               case 44:
                  if ((0x3ff000000000000L & l) != 0L)
                     { jjCheckNAddTwoStates(44, 37); }
                  break;
               case 45:
                  if (curChar == 47)
                     { jjAddStates(12, 13); }
                  break;
               case 47:
                  if ((0xfffffffffffffbffL & l) != 0L)
                     { jjCheckNAddTwoStates(47, 48); }
                  break;
               case 48:
                  if (curChar == 10 && kind > 64)
                     kind = 64;
                  break;
               case 49:
                  if (curChar != 47)
                     break;
                  if (kind > 65)
                     kind = 65;
                  { jjCheckNAddStates(0, 2); }
                  break;
               case 50:
                  if ((0xffffffffffffdbffL & l) == 0L)
                     break;
                  if (kind > 65)
                     kind = 65;
                  { jjCheckNAddStates(0, 2); }
                  break;
               case 51:
                  if ((0x2400L & l) != 0L && kind > 65)
                     kind = 65;
                  break;
               case 52:
                  if (curChar == 10 && kind > 65)
                     kind = 65;
                  break;
               case 53:
                  if (curChar == 13)
                     jjstateSet[jjnewStateCnt++] = 52;
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else if (curChar < 128)
      {
         long l = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               case 0:
                  if ((0x7fffffe07fffffeL & l) != 0L)
                  {
                     if (kind > 58)
                        kind = 58;
                     { jjCheckNAdd(26); }
                  }
                  else if (curChar == 95)
                  {
                     if (kind > 47)
                        kind = 47;
                  }
                  break;
               case 2:
                  if ((0xffffffffefffffffL & l) != 0L)
                     { jjCheckNAddStates(17, 19); }
                  break;
               case 4:
                  if (curChar == 92)
                     { jjAddStates(20, 27); }
                  break;
               case 6:
                  if (curChar == 92)
                     { jjCheckNAddStates(17, 19); }
                  break;
               case 8:
                  if ((0x400000004L & l) != 0L)
                     { jjCheckNAddStates(17, 19); }
                  break;
               case 9:
                  if ((0x4000000040L & l) != 0L)
                     { jjCheckNAddStates(17, 19); }
                  break;
               case 10:
                  if ((0x400000004000L & l) != 0L)
                     { jjCheckNAddStates(17, 19); }
                  break;
               case 11:
                  if ((0x4000000040000L & l) != 0L)
                     { jjCheckNAddStates(17, 19); }
                  break;
               case 12:
                  if ((0x10000000100000L & l) != 0L)
                     { jjCheckNAddStates(17, 19); }
                  break;
               case 14:
                  if ((0xffffffffefffffffL & l) != 0L)
                     { jjCheckNAddStates(14, 16); }
                  break;
               case 16:
                  if (curChar == 92)
                     { jjAddStates(28, 35); }
                  break;
               case 18:
                  if (curChar == 92)
                     { jjCheckNAddStates(14, 16); }
                  break;
               case 20:
                  if ((0x400000004L & l) != 0L)
                     { jjCheckNAddStates(14, 16); }
                  break;
               case 21:
                  if ((0x4000000040L & l) != 0L)
                     { jjCheckNAddStates(14, 16); }
                  break;
               case 22:
                  if ((0x400000004000L & l) != 0L)
                     { jjCheckNAddStates(14, 16); }
                  break;
               case 23:
                  if ((0x4000000040000L & l) != 0L)
                     { jjCheckNAddStates(14, 16); }
                  break;
               case 24:
                  if ((0x10000000100000L & l) != 0L)
                     { jjCheckNAddStates(14, 16); }
                  break;
               case 25:
                  if ((0x7fffffe07fffffeL & l) == 0L)
                     break;
                  if (kind > 58)
                     kind = 58;
                  { jjCheckNAdd(26); }
                  break;
               case 26:
                  if ((0x7fffffe87fffffeL & l) == 0L)
                     break;
                  if (kind > 58)
                     kind = 58;
                  { jjCheckNAdd(26); }
                  break;
               case 28:
                  if ((0x7fffffe07fffffeL & l) == 0L)
                     break;
                  if (kind > 59)
                     kind = 59;
                  { jjCheckNAdd(29); }
                  break;
               case 29:
                  if ((0x7fffffe87fffffeL & l) == 0L)
                     break;
                  if (kind > 59)
                     kind = 59;
                  { jjCheckNAdd(29); }
                  break;
               case 37:
                  if ((0x4000000040L & l) != 0L && kind > 44)
                     kind = 44;
                  break;
               case 47:
                  { jjAddStates(36, 37); }
                  break;
               case 50:
                  if (kind > 65)
                     kind = 65;
                  { jjAddStates(0, 2); }
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else
      {
         int i2 = (curChar & 0xff) >> 6;
         long l2 = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               case 2:
                  if ((jjbitVec0[i2] & l2) != 0L)
                     { jjAddStates(17, 19); }
                  break;
               case 14:
                  if ((jjbitVec0[i2] & l2) != 0L)
                     { jjAddStates(14, 16); }
                  break;
               case 47:
                  if ((jjbitVec0[i2] & l2) != 0L)
                     { jjAddStates(36, 37); }
                  break;
               case 50:
                  if ((jjbitVec0[i2] & l2) == 0L)
                     break;
                  if (kind > 65)
                     kind = 65;
                  { jjAddStates(0, 2); }
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      if (kind != 0x7fffffff)
      {
         jjmatchedKind = kind;
         jjmatchedPos = curPos;
         kind = 0x7fffffff;
      }
      ++curPos;
      if ((i = jjnewStateCnt) == (startsAt = 54 - (jjnewStateCnt = startsAt)))
         return curPos;
      try { curChar = input_stream.readChar(); }
      catch(java.io.IOException e) { return curPos; }
   }
}
static final int[] jjnextStates = {
   50, 51, 53, 31, 32, 33, 34, 36, 37, 38, 39, 41, 46, 49, 14, 15, 
   16, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 17, 18, 19, 20, 
   21, 22, 23, 24, 47, 48, 
};

/** Token literal values. */
public static final String[] jjstrLiteralImages = {
"", null, null, null, null, null, null, null, null, null, null, null, "\136", 
"\57", null, "\55", "\45", "\52", "\53", "\50", "\51", "\133", "\135", "\72", "\54", 
"\56", "\77", "\74", "\76", "\74\75", "\76\75", "\75", "\41\75", "\176\75", "\72\75", 
null, null, null, null, null, null, null, null, null, null, null, null, null, null, 
null, null, null, null, null, null, null, null, null, null, null, null, null, null, 
null, null, null, "\73", };
protected Token jjFillToken()
{
   final Token t;
   final String curTokenImage;
   final int beginLine;
   final int endLine;
   final int beginColumn;
   final int endColumn;
   String im = jjstrLiteralImages[jjmatchedKind];
   curTokenImage = (im == null) ? input_stream.GetImage() : im;
   beginLine = input_stream.getBeginLine();
   beginColumn = input_stream.getBeginColumn();
   endLine = input_stream.getEndLine();
   endColumn = input_stream.getEndColumn();
   t = Token.newToken(jjmatchedKind, curTokenImage);

   t.beginLine = beginLine;
   t.endLine = endLine;
   t.beginColumn = beginColumn;
   t.endColumn = endColumn;

   return t;
}

int curLexState = 0;
int defaultLexState = 0;
int jjnewStateCnt;
int jjround;
int jjmatchedPos;
int jjmatchedKind;

/** Get the next Token. */
public Token getNextToken() 
{
  Token matchedToken;
  int curPos = 0;

  EOFLoop :
  for (;;)
  {
   try
   {
      curChar = input_stream.BeginToken();
   }
   catch(java.io.IOException e)
   {
      jjmatchedKind = 0;
      jjmatchedPos = -1;
      matchedToken = jjFillToken();
      return matchedToken;
   }

   try { input_stream.backup(0);
      while (curChar <= 32 && (0x100002600L & (1L << curChar)) != 0L)
         curChar = input_stream.BeginToken();
   }
   catch (java.io.IOException e1) { continue EOFLoop; }
   jjmatchedKind = 0x7fffffff;
   jjmatchedPos = 0;
   curPos = jjMoveStringLiteralDfa0_0();
   if (jjmatchedKind != 0x7fffffff)
   {
      if (jjmatchedPos + 1 < curPos)
         input_stream.backup(curPos - jjmatchedPos - 1);
      if ((jjtoToken[jjmatchedKind >> 6] & (1L << (jjmatchedKind & 077))) != 0L)
      {
         matchedToken = jjFillToken();
         return matchedToken;
      }
      else
      {
         continue EOFLoop;
      }
   }
   int error_line = input_stream.getEndLine();
   int error_column = input_stream.getEndColumn();
   String error_after = null;
   boolean EOFSeen = false;
   try { input_stream.readChar(); input_stream.backup(1); }
   catch (java.io.IOException e1) {
      EOFSeen = true;
      error_after = curPos <= 1 ? "" : input_stream.GetImage();
      if (curChar == '\n' || curChar == '\r') {
         error_line++;
         error_column = 0;
      }
      else
         error_column++;
   }
   if (!EOFSeen) {
      input_stream.backup(1);
      error_after = curPos <= 1 ? "" : input_stream.GetImage();
   }
   throw new TokenMgrError(EOFSeen, curLexState, error_line, error_column, error_after, curChar, TokenMgrError.LEXICAL_ERROR);
  }
}

private void jjCheckNAdd(int state)
{
   if (jjrounds[state] != jjround)
   {
      jjstateSet[jjnewStateCnt++] = state;
      jjrounds[state] = jjround;
   }
}
private void jjAddStates(int start, int end)
{
   do {
      jjstateSet[jjnewStateCnt++] = jjnextStates[start];
   } while (start++ != end);
}
private void jjCheckNAddTwoStates(int state1, int state2)
{
   jjCheckNAdd(state1);
   jjCheckNAdd(state2);
}

private void jjCheckNAddStates(int start, int end)
{
   do {
      jjCheckNAdd(jjnextStates[start]);
   } while (start++ != end);
}

    /** Constructor. */
    public SQLPPTokenManager(SimpleCharStream stream){

      if (SimpleCharStream.staticFlag)
            throw new Error("ERROR: Cannot use a static CharStream class with a non-static lexical analyzer.");

    input_stream = stream;
  }

  /** Constructor. */
  public SQLPPTokenManager (SimpleCharStream stream, int lexState){
    ReInit(stream);
    SwitchTo(lexState);
  }

  /** Reinitialise parser. */
  public void ReInit(SimpleCharStream stream)
  {
    jjmatchedPos = jjnewStateCnt = 0;
    curLexState = defaultLexState;
    input_stream = stream;
    ReInitRounds();
  }

  private void ReInitRounds()
  {
    int i;
    jjround = 0x80000001;
    for (i = 54; i-- > 0;)
      jjrounds[i] = 0x80000000;
  }

  /** Reinitialise parser. */
  public void ReInit(SimpleCharStream stream, int lexState)
  {
    ReInit(stream);
    SwitchTo(lexState);
  }

  /** Switch to specified lex state. */
  public void SwitchTo(int lexState)
  {
    if (lexState >= 1 || lexState < 0)
      throw new TokenMgrError("Error: Ignoring invalid lexical state : " + lexState + ". State unchanged.", TokenMgrError.INVALID_LEXICAL_STATE);
    else
      curLexState = lexState;
  }

/** Lexer state names. */
public static final String[] lexStateNames = {
   "DEFAULT",
};
static final long[] jjtoToken = {
   0xc01bbffffffffffL, 0x4L, 
};
static final long[] jjtoSkip = {
   0xf000000000000000L, 0x3L, 
};
    protected SimpleCharStream  input_stream;

    private final int[] jjrounds = new int[54];
    private final int[] jjstateSet = new int[2 * 54];

    
    protected char curChar;
}
