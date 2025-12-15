package edu.grinnell.csc207.soundsofsorting.rendering;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import edu.grinnell.csc207.soundsofsorting.audio.NoteIndices;
import java.util.*;

/**
 * A drawing panel for visualizing the contents of a @NoteIndices object.
 */
public class ArrayPanel extends JPanel {
    @SuppressWarnings("unused")
    private NoteIndices notes;
   
    /**
     * Create a new <code>ArrayPanel</code> with the given notes and dimensions.
     * @param notes the note indices 
     * @param width the width of the panel
     * @param height the height of the panel
     */
    public ArrayPanel(NoteIndices notes, int width, int height) {
        this.notes = notes;
        this.setPreferredSize(new Dimension(width, height));
    }

    /**
     * Painting to our screen
     * @param g a graphics object
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        Integer[] notes = this.notes.getNotes();

        // find max for scaling
        // List<Integer> notesList = Arrays.asList(notes);
        // Integer maximum = Collections.max(notesList);
        int maximum = -1;
        for (int i : notes){
            if (i>maximum){
                maximum = i;
            }
        }

        // paint each note
        for (int i=0; i<notes.length; i++) {
            double width = (double) getWidth() / notes.length;
            int w = Math.max(1, (int) Math.round(width)); // ensure at least 1 px
            int x = (int) Math.round(i * width);
            double fraction = (double) notes[i] / maximum;
            int height = (int) (fraction * getHeight());
            int y = getHeight() - height;

            g.fillRect(x, y, w, height);
            g.drawRect(x, y, w, height);
        }   
    }
}