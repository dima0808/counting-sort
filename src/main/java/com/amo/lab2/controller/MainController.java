package com.amo.lab2.controller;

import com.amo.lab2.utils.CountingSort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @GetMapping
    public String showChart(Model model) {

        int[] valuesX = new int[]{50, 100, 300, 500, 700, 1000, 1300, 1600,
                2000, 2400, 2800, 3300, 3800, 4300, 4900, 5500,
                6200, 6900, 7600, 8400, 9200, 10000, 11000, 12000};
        double[] valuesY1 = new double[valuesX.length];
        long[] valuesY2 = new long[valuesX.length];

        for (int i = 0; i < valuesX.length; i++) {
            CountingSort tempSort = new CountingSort(valuesX[i]);
            valuesY1[i] = (double) tempSort.getTime() / 1000000;
            valuesY2[i] = tempSort.getOperationsCount();

            model.addAttribute("valuesX", valuesX);
            model.addAttribute("valuesY1", valuesY1);
            model.addAttribute("valuesY2", valuesY2);
        }
        return "form";
    }

    @PostMapping("/processSorting")
    public String doSorting(@RequestParam("array") String array, Model model) {

        String[] stringArray = array.split(" ");
        int[] intArray = new int[stringArray.length];
        for (int i = 0; i < stringArray.length; i++) {
            intArray[i] = Integer.parseInt(stringArray[i]);
        }

        CountingSort countingSort = new CountingSort(intArray);

        model.addAttribute("countingSort", countingSort);

        return "sort";
    }

    @PostMapping("/processSortingRandom")
    public String doSortingRandom(@RequestParam("randomAmount") int randomAmount, Model model) {

        CountingSort countingSort = new CountingSort(randomAmount);

        model.addAttribute("countingSort", countingSort);

        return "sort";
    }
}