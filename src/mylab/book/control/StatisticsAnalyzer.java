package mylab.book.control;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import mylab.book.entity.Magazine;
import mylab.book.entity.Novel;
import mylab.book.entity.Publication;
import mylab.book.entity.ReferenceBook;

public class StatisticsAnalyzer {

    public Map<String, Double> calculateAveragePriceByType(Publication[] publications) {
        Map<String, Integer> totalPriceMap = new HashMap<String, Integer>();
        Map<String, Integer> countMap = new HashMap<String, Integer>();
        Map<String, Double> averageMap = new HashMap<String, Double>();

        for (Publication pub : publications) {
            String type = getPublicationType(pub);
            totalPriceMap.put(type, totalPriceMap.getOrDefault(type, 0) + pub.getPrice());
            countMap.put(type, countMap.getOrDefault(type, 0) + 1);
        }

        for (String type : totalPriceMap.keySet()) {
            double avg = (double) totalPriceMap.get(type) / countMap.get(type);
            averageMap.put(type, avg);
        }

        return averageMap;
    }

    public Map<String, Double> calculatePublicationDistribution(Publication[] publications) {
        Map<String, Integer> countMap = new HashMap<String, Integer>();
        Map<String, Double> distributionMap = new HashMap<String, Double>();

        for (Publication pub : publications) {
            String type = getPublicationType(pub);
            countMap.put(type, countMap.getOrDefault(type, 0) + 1);
        }

        for (String type : countMap.keySet()) {
            double ratio = (double) countMap.get(type) / publications.length * 100.0;
            distributionMap.put(type, ratio);
        }

        return distributionMap;
    }

    public double calculatePublicationRatioByYear(Publication[] publications, String year) {
        int count = 0;

        for (Publication pub : publications) {
            if (pub.getPublishDate().startsWith(year)) {
                count++;
            }
        }

        return (double) count / publications.length * 100.0;
    }

    private String getPublicationType(Publication pub) {
        if (pub instanceof Novel) {
            return "소설";
        } else if (pub instanceof Magazine) {
            return "잡지";
        } else if (pub instanceof ReferenceBook) {
            return "참고서";
        } else {
            return "기타";
        }
    }

    public void printStatistics(Publication[] publications) {
        DecimalFormat wonFormat = new DecimalFormat("#,###");
        DecimalFormat ratioFormat = new DecimalFormat("0.00");

        Map<String, Double> avgMap = calculateAveragePriceByType(publications);
        Map<String, Double> distMap = calculatePublicationDistribution(publications);
        double yearRatio = calculatePublicationRatioByYear(publications, "2007");

        System.out.println("===== 출판물 통계 분석 =====");

        System.out.println("1. 타입별 평균 가격:");
        if (avgMap.containsKey("소설")) {
            System.out.println("   - 소설: " + wonFormat.format(avgMap.get("소설")) + "원");
        }
        if (avgMap.containsKey("참고서")) {
            System.out.println("   - 참고서: " + wonFormat.format(avgMap.get("참고서")) + "원");
        }
        if (avgMap.containsKey("잡지")) {
            System.out.println("   - 잡지: " + wonFormat.format(avgMap.get("잡지")) + "원");
        }

        System.out.println();
        System.out.println("2. 출판물 유형 분포:");
        if (distMap.containsKey("소설")) {
            System.out.println("   - 소설: " + ratioFormat.format(distMap.get("소설")) + "%");
        }
        if (distMap.containsKey("참고서")) {
            System.out.println("   - 참고서: " + ratioFormat.format(distMap.get("참고서")) + "%");
        }
        if (distMap.containsKey("잡지")) {
            System.out.println("   - 잡지: " + ratioFormat.format(distMap.get("잡지")) + "%");
        }

        System.out.println();
        System.out.println("3. 2007년에 출판된 출판물 비율: " + ratioFormat.format(yearRatio) + "%");
    }
}