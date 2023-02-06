for (int i = 0; i < grid.size(); i++) {
                char[] chararray = grid.get(i).toCharArray();
                Arrays.sort(chararray);
                grid.set(i, new String(chararray));
            }

            for (int i = 0; i < grid.get(0).length(); i++) {
                for (int j = 0; j < grid.size()-1; j++) {
                    if (grid.get(j).charAt(i) > grid.get(j+1).charAt(i)) {
                        return "NO";
                    }
                }
            }
            return "YES";
