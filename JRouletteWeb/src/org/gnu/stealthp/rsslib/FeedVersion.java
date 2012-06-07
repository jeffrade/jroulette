//$Id: FeedVersion.java,v 1.6 2005/02/13 22:48:12 taganaka Exp $
package org.gnu.stealthp.rsslib;

/**
 * FeedVersion  class.
 * This class try to collect information about feed version
 *
 * <blockquote>
 * <em>This module, both source code and documentation, is in the
 * Public Domain, and comes with <strong>NO WARRANTY</strong>.</em>
 * </blockquote>
 *
 * @since RSSLIB4J 0.3
 * @author Francesco aka 'Stealthp' stealthp[@]stealthp.org
 * @version 0.3
 */

public class FeedVersion {

    /**
     * Version number
     */
    private double version;
    /**
     * Namespace used
     */
    private String namespace;


    /**
     * Blank costructor
     */
    public FeedVersion() {
    }

    /**
     * Costructor
     * @param version double Feed version
     * @param namespace String Feed Namespace
     */
    public FeedVersion(double version, String namespace) {
        this.version = version;
        this.namespace = namespace;
    }

    /**
     * Set the feed version number
     * @param Version double
     */
    public void setVersion(double Version) {

        this.version = Version;
    }

    /**
     * Set namespace's fees
     * @param Namespace String
     */
    public void setNamespace(String Namespace) {
        this.namespace = Namespace;

    }

    /**
     * Get the document version
     * @return double the version
     */
    public double getVersion() {
        if (namespace != null && namespace.equals("http://purl.org/rss/1.0/")) version = 1d;
        return version;
    }

    /**
     * Get the namespace
     * @return String Namespace
     */
    public String getNamespace() {
        return namespace;
    }

    /**
     * Version information
     * @return String
     */
    public String toString() {
        return "VERSION NUMBER: " + this.getVersion() + ", NAMESPACE: " + this.getNamespace();
    }

}
