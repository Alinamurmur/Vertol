package com.example.alinamurmur.myprojektiswork.Interfaces;

/**
 * Created by Александр on 21.07.2017.
 */

public interface eventListener {
    void sectionClickListener(int i, int section);
    void onReturnToSection (int section);
    void someEvent(int i);
    void onDiscountSelected (String title);
    void onEventSelected (String title);
    void onMonthSelected(String month);
    void onArticleSelected(String title, int id, int section);


}
