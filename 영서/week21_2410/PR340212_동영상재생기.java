package week21_2410;

public class PR340212_동영상재생기 {
    class Solution {
        int convertedStart;
        int convertedEnd;

        public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
            StringBuilder sb = new StringBuilder();
            convertedStart = Integer.parseInt(op_start.split(":")[0]) * 60 + Integer.parseInt(op_start.split(":")[1]);
            convertedEnd = Integer.parseInt(op_end.split(":")[0]) * 60 + Integer.parseInt(op_end.split(":")[1]);

            int mm = Integer.parseInt(pos.split(":")[0]);
            int ss = Integer.parseInt(pos.split(":")[1]);

            if (isOpening(mm, ss)) {
                mm = Integer.parseInt(op_end.split(":")[0]);
                ss = Integer.parseInt(op_end.split(":")[1]);
            }//isOpening

            for (String command : commands) {

                switch (command) {
                    case "prev":
                        ss -= 10;
                        if (ss < 0) {
                            if (mm == 0) {
                                ss = 0;
                            } else {
                                mm -= 1;
                                ss += 60;
                            }
                        }
                        break;
                    case "next":
                        ss += 10;
                        if (ss >= 60) {
                            mm += 1;
                            ss -= 60;
                        }
                        if (mm == Integer.parseInt(video_len.split(":")[0]) && ss > Integer.parseInt(video_len.split(":")[1])) {
                            ss = Integer.parseInt(video_len.split(":")[1]);
                        }
                        break;
                }
                if (isOpening(mm, ss)) {
                    mm = Integer.parseInt(op_end.split(":")[0]);
                    ss = Integer.parseInt(op_end.split(":")[1]);
                }//isOpening
            }//for

            sb.append(String.format("%02d", mm)).append(":").append(String.format("%02d", ss));

            return sb.toString();
        }//solution

        boolean isOpening(int mm, int ss) {
            int convert = mm * 60 + ss;
            return convert >= convertedStart && convert <= convertedEnd;
        }//is_opening
    }//solution
}//class