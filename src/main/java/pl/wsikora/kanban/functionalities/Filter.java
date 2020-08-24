//package pl.wsikora.kanban.functionalities;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//public class Filter {
//    private List<Issue> list;
//
//    public Filter(List<Issue> list) {
//        this.list = list;
//    }
//
//    public void getByTitle(String value) {
//        this.list = list
//                .stream()
//                .filter(e -> e.getTitle().toLowerCase().equals(value.toLowerCase()))
//                .collect(Collectors.toList());
//    }
//
//    public void getByTitleLike(String partOfValue) {
//        this.list = list
//                .stream()
//                .filter(e -> e.getTitle().toLowerCase().contains(partOfValue.toLowerCase()))
//                .collect(Collectors.toList());
//    }
//
//    public void getByAuthor(String value) {
//        this.list = list
//                .stream()
//                .filter(e -> e.getAuthor().getUserName().toLowerCase().equals(value.toLowerCase()))
//                .collect(Collectors.toList());
//    }
//
//    public void getByAuthorLike(String partOfValue) {
//        this.list = list
//                .stream()
//                .filter(e -> e.getAuthor().getUserName().toLowerCase().contains(partOfValue.toLowerCase()))
//                .collect(Collectors.toList());
//    }
//
//    public void getByState(String value) {
//        this.list = list
//                .stream()
//                .filter(e -> e.getState().equals(value))
//                .collect(Collectors.toList());
//    }
//
//    public void getByMilestone(String value) {
//        this.list = list
//                .stream()
//                .filter(e -> e.getMilestone().getTitle().toLowerCase().equals(value.toLowerCase()))
//                .collect(Collectors.toList());
//    }
//
//    public void getByMilestoneLike(String partOfValue) {
//        this.list = list
//                .stream()
//                .filter(e -> e.getMilestone().getTitle().toLowerCase().contains(partOfValue.toLowerCase()))
//                .collect(Collectors.toList());
//    }
//
//    public void getByLabels(String value) {
//        this.list = list
//                .stream()
//                .filter(e -> e.getLabels().contains(value))
//                .collect(Collectors.toList());
//    }
//
////    public void getByLabelsLike(String partOfValue) {
////        this.list = list
////                .stream()
////                .filter(e -> e.getLabels().contains(value))
////                .collect(Collectors.toList());
////    }
//
//    public List<Issue> getAsList() {
//        return list;
//    }
//
//}
